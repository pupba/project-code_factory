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
	filter2D(src, blr, CV_8UC1, mask, Point(-1, -1));
	
	float alpha = 0.5;
	Mat sharpen = (1.0 + alpha) * src - alpha * blr;
	
	imshow("Sharpening", sharpen);
	waitKey(0);
	return 0;
}
