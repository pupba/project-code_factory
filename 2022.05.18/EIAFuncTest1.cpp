// 지수,강도, 각도 함수 테스트
#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat m1 = (Mat_ <uchar>(2, 3) << 0, 1, 2, 3, 4, 5);
	cout << "[m1] = " << endl << m1 << endl << endl;

	Mat m_exp,m_log,m_sqrt,m_pow;
	m1.convertTo(m1, CV_32F);
	exp(m1, m_exp);
	cout << "[exp()] = " << endl << m_exp << endl << endl;
	log(m1, m_log);
	cout << "[log()] = " << endl << m_log << endl << endl;
	sqrt(m1, m_sqrt);
	cout << "[sqrt()] = " << endl << m_sqrt << endl << endl;
	pow(m1, 0.2 ,m_pow);
	cout << "[pow()] = " << endl << m_exp << endl << endl;
	return 0;
}

