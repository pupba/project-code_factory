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

int main()
{
	Mat img = imread("./img/catbread.jpg");
	resize(img, img, Size(500, 500));
	imshow("Origin", img);

	Mat hist = getHistogram(img, 0, 256, 256);
	Mat histImg = getHistImg(hist);

	imshow("Histogram", histImg);

	waitKey(0);
	return 0;
}
