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
	Mat dst;
	randn(noise, 0, 50);
	add(src, noise, dst, noArray(), src.type());
	imshow("Gaussian Noise, std = 50", dst);

	waitKey(0);
	return 0;
}
