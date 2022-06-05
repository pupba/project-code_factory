#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat img = imread("./img/hawkes.bmp",IMREAD_GRAYSCALE);

	imshow("Origin", img);

	float ker[] = {
		1,1,0,
		1,0,-1,
		0,-1,-1};
	int Nw, Nh;
	Nw = Nh = 3;
	Mat mask = Mat(Nh, Nw, CV_32FC1, ker);
	Mat dst;
	filter2D(img, dst, -1, mask, Point(-1, -1), 127.0);
	imshow("Embosing", dst);

	waitKey(0);
	return 0;
}
