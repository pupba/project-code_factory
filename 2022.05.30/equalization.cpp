#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

Mat getHistImg(Mat hist_ori) {
	double maxValue;
	minMaxLoc(hist_ori, 0, &maxValue, 0, 0); // 히스토그램에서최대값탐색
	Mat hist = hist_ori / maxValue; // 히스토그램의모든값을0~1 사이의값으로정규화
	Mat histImg = Mat(100, 256, CV_8U, Scalar(255));
	for (int i = 0; i < 256; i++)
		if (hist.at<float>(i) != 0.0)
			line(histImg, Point(i, 100), Point(i, 100 - cvRound(hist.at<float>(i) * 100)), Scalar(0));
	return histImg;
}
Mat getHistogram(Mat img, int low, int high, int bin) {
	Mat hist;
	int channels[] = { 0 }; // 채널 1개
	int histSize[] = { bin }; // 히스토그램 빈의 개수
	float graylevel[] = { low, high }; // 영상의 그레이 레벨 최소,최대 값
	const float* ranges[] = { graylevel };
	calcHist(&img, 1, channels, noArray(), hist, 1, histSize, ranges);
	return hist;
}

Mat accmHistogram(Mat h) {
	Mat accHist = Mat(h.size(), h.type(), Scalar(0));
	accHist.at<float>(0) = h.at<float>(0);
	for (int i = 1; i < h.rows; i++) {
		accHist.at<float>(i) = accHist.at<float>(i - 1) + h.at<float>(i);

	}
	return accHist;
}
Mat HistEqual(Mat src) {
	Mat hist = getHistogram(src, 0, 256, 256);
	Mat hist_acc = accmHistogram(hist);
	hist_acc = hist_acc / hist_acc.at<float>(hist_acc.rows - 1);
	hist_acc *= 255;
	Mat equal_img = Mat(src.size(), src.type());
	for (int i = 0; i < src.rows; i++) {
		uchar* p = src.ptr<uchar>(i);
		uchar* q = equal_img.ptr<uchar>(i);
		for (int j = 0; j < src.cols; j++) {
			int idx = *p;
			*q = cvRound(hist_acc.at<float>(idx));
			p++; q++;
		}
	}
	return equal_img;
}
int main()
{
	Mat img = imread("./img/hawkes.bmp",IMREAD_GRAYSCALE);

	imshow("Origin", img);

	Mat hist = getHistogram(img, 0, 256, 256);
	imshow("Histogram", getHistImg(hist));

	Mat equal_img = HistEqual(img);
	Mat eq_hist = getHistogram(equal_img,0,256,256);
	imshow("equal_img", equal_img);
	imshow("Histogram_eq", getHistImg(eq_hist));

	waitKey(0);
	return 0;
}
