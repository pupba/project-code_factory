// 지수,강도, 각도 함수 테스트
#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat mx = (Mat_ <float>(2, 3) << -3, -2, -1, 0, 1, 2);
	cout << "[mx] = " << endl << mx << endl << endl;
	Mat my = (Mat_ <float>(2, 3) << 1, 1, 1, 1, 1, 1);
	cout << "[my] = " << endl << my << endl << endl;

	Mat m_mag, m_angle;
	magnitude(mx, my, m_mag);
	cout << "[m_mag] = " << endl << m_mag << endl << endl;
	phase(mx, my, m_angle, true);
	cout << "[m_angle] = " << endl << m_angle << endl << endl;
	cartToPolar(mx, my, m_mag, m_angle);
	cout << "--cartToPolar()--" << endl;
	cout << "[m_mag] = " << endl << m_mag << endl << endl;
	cout << "[m_angle] = " << endl << m_angle << endl << endl;
	Mat mx1, my1;
	polarToCart(m_mag, m_angle, mx1, my1);
	cout << "--polarToCart()--" << endl;
	cout << "[mx1] = " << endl << mx1 << endl << endl;
	cout << "[my1] = " << endl << my1 << endl << endl;
	return 0;
}

