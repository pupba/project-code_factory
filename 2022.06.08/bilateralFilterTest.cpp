#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat src = imread("./img/cat1.jpg");
	resize(src, src, Size(500, 500));
	imshow("Origin", src);

	Mat noise = Mat(src.size(), src.type());
	randn(noise, 0, 50);
	Mat dst;
	add(src, noise, dst, noArray(), src.type());

	imshow("Gaussian Noise std = 50", dst);
	Mat gau;
	GaussianBlur(src, gau, Size(9, 9), 5);
	imshow("Gaussian blur", gau);
	Mat bil;
	bilateralFilter(src, bil, -1, 30, 5);
	imshow("BIlateral", bil);
	waitKey(0);
	return 0;
}
