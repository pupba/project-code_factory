#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat src = imread("./img/cat1.jpg",IMREAD_GRAYSCALE);
	resize(src, src, Size(500, 500));
	imshow("Origin", src);
	
	Mat mask = Mat(5, 5, CV_32FC1, Scalar(1));
	mask /= 25;
	Mat blr;
	filter2D(src, blr, CV_16SC1, mask, Point(-1, -1));

	Mat src1;
	src.convertTo(src1, CV_16SC1);
	Mat tmp = src1 - blr; // 원본 - 블러링
	Mat res = src1 + tmp; // 샤프닝 = 원본 + (원본 - 블러링)

	blr.convertTo(blr, CV_8UC1);
	imshow("blurring", blr);

	tmp.convertTo(tmp, CV_8UC1);
	imshow("difference", tmp);

	res.convertTo(res, CV_8UC1);
	imshow("sharpening", res);

	waitKey(0);
	return 0;
}
