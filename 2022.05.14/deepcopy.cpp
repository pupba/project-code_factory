#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat m1 = (Mat_ <uchar>(3, 3) << 1, 2, 3, 4, 5, 6, 7, 8, 9);
	Mat mask = (Mat_ <uchar>(3, 3) << 0, 1, 1, 0, 1, 1, 1, 0, 0);
	Mat m2, m3, m4;

	cout << "m1 = \n" << m1 << endl << endl;
	cout << "mask = \n" << mask << endl << endl;

	m2 = m1.clone();
	cout << "--m1.clone() >> m2--" << endl;
	cout << "m2 = \n" << m2 << endl << endl;

	m3.setTo(Scalar(0));
	cout << "--Test Deep Copy--" << endl;
	cout << "m1 = \n" << m1 << endl;
	cout << "m2 = \n" << m2 << endl << endl;

	m1.copyTo(m3);
	cout << "--m1.copyTo(m3)--" << endl;
	cout << "m3 = \n" << m3 << endl << endl;
	
	m1.copyTo(m4, mask);
	cout << "--m1.copyTo(m4,mask)--" << endl;
	cout << "m4 = \n" << m4 << endl << endl;

	return 0;
}
