#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat m1 = (Mat_ <uchar>(2, 3) << 0,500,100,400,100,500);
	cout << "[m1] = " << endl << m1 << endl << endl;
	Mat dst;
	normalize(m1, dst, 0, 255, NORM_MINMAX, CV_8U);
	cout << "[normalize 0~255] = " << endl << dst << endl;
	return 0;
}
