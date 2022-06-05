#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat airplane = imread("./img/airplane.bmp");
	Mat mask = imread("./img/mask_plane.bmp");
	Mat background = imread("./img/field.bmp");
	TickMeter tm;
	if (airplane.empty() || mask.empty() || background.empty()) {
		cerr << "image open faild!!" << endl;
		exit(1);
	}
	
	tm.start();
	airplane.copyTo(background, mask);
	tm.stop();

	cout << "---TickMeter_ptr 함수---" << endl;
	cout << tm.getTimeMilli() << endl << endl;
	cout << "---TickMeter::getCounter()---" << endl;
	cout << tm.getCounter() << endl;
	waitKey(0);
	return 0;
}
