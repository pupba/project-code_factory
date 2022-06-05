#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat airplane = imread("./img/airplane.bmp");
	
	Mat mask = imread("./img/mask_plane.bmp");

	Mat background = imread("./img/field.bmp");

	if (airplane.empty() || mask.empty() || background.empty()) {
		cerr << "image open faild!!" << endl;
		exit(1);
	}
	imshow("airplane", airplane);
	imshow("mask", mask);
	imshow("background", background);

	airplane.copyTo(background, mask);
	imshow("background_merge", background);

	waitKey(0);
	return 0;
}
