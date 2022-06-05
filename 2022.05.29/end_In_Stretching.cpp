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
Mat histogram_stretching(Mat img) {
	double maxvalue, minvalue;
	minMaxLoc(img, &minvalue, &maxvalue);

	Mat res = (img - minvalue) * 255 / (maxvalue - minvalue);
	return res;
}
int getMinGray(Mat hist, float theshold) {
	// hist를왼쪽부터탐색하면서, 
	// 저장된값의누적합이threshold보다크게되는첨자반환
	float npixel = 0.;
	int i;
	for (i = 0; i < hist.rows; i++) {
		npixel += hist.at<float>(i);
		if (npixel >= theshold) break;
	}
	return i;
}
int getMaxGray(Mat hist, float theshold) {
	// hist를오른쪽부터탐색하면서, 
	// 저장된값의누적합이threshold보다크게되는첨자반환
	float npixel = 0.;
	int i;
	for (i = hist.rows - 1; i >= 0; i--) {
		npixel += hist.at<float>(i);
		if (npixel >= theshold) break;
	}
	return i;
}
Mat histo_stretching_Endln(Mat img, float percentile) {
	// img: 입력영상
	// percentile : 입력영상에서잡음으로처리할화소의비율(예: 0.01일경우1%의화소를잡음처리)
	Mat hist = getHistogram(img, 0, 256, 256);// 히스토그램구하기
	int minGray = getMinGray(hist, // 임계치를넘는최소밝기탐색
		percentile * 0.5 * img.rows * img.cols);// 전체잡음의절반을왼쪽에서탐색
	int maxGray = getMaxGray(hist, // 임계치를넘는최대밝기탐색
		percentile * 0.5 * img.rows * img.cols);// 전체잡음의절반은오른쪽에서탐색
	cout << " min = " << minGray << endl
		<< " max = " << maxGray << endl;
	Mat res = ((img - minGray) / (maxGray - minGray)) * 255; // 변환 함수 적용
	return res;
}
int main()
{
	Mat img = imread("./img/catbread.jpg",IMREAD_GRAYSCALE);
	resize(img, img, Size(300, 300));
	imshow("Origin", img);

	Mat hist = getHistogram(img, 0, 256, 256);
	
	Mat stret = histogram_stretching(img);
	imshow("Stretching", stret);
	Mat hist_st = getHistogram(stret,0,256,256);

	Mat endIn = histo_stretching_Endln(img,0.05);
	imshow("End_In_Stretching", endIn);
	Mat hist_endIn = getHistogram(endIn, 0, 256, 256);

	imshow("Histogram", getHistImg(hist));
	imshow("Histogram_Stret", getHistImg(hist_st));
	imshow("Histogram_End_In_Stretching", getHistImg(hist_endIn));

	waitKey(0);
	return 0;
}
