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
	int t1 = getTickCount();
	airplane.copyTo(background, mask);
	double freq = getTickFrequency();
	int t2 = getTickCount();

	cout << "---getTickCount()---" << endl;
	cout << t2 - t1 << endl << endl;
	cout << "---getTickFrequency()---" << endl;
	cout << "소요 시간(ms) = " << ((t2 - t1) * 1000) / freq << endl << endl;

	waitKey(0);
	return 0;
}
