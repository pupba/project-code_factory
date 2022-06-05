#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat m1 = (Mat_ <uchar>(2, 3) << 0, -1, 2, 3, -4, 5, -6);
	cout << "[m1] = " << endl << m1 << endl << endl;
	MatExpr mabs = abs(m1);
	cout << "[abs] = " << endl << mabs << endl << endl;
	
	Mat m2 = (Mat_ <uchar>(2, 3) << 5, 2, 3, 4, 5, 6);
	cout << "[m1] = " << endl << m2 << endl << endl;

	Mat m_absdiff;
	absdiff(m1, m2, m_absdiff);
	cout << "[absdiff] = " << endl << m_absdiff << endl << endl;

	Mat m_csa;
	convertScaleAbs(m1, m_csa);
	cout << "alpha = 1, beta = 0" << endl;
	cout << "[convertScaleAbs] = " << endl << m_csa << endl;
	return 0;
}

