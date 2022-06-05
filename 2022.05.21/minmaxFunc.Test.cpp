#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	uchar data[] = {
		10,200,5,7,9,
		15,35,60,80,170,
		100,2,55,37,70
	};
	Mat m1(3, 5, CV_8U, data);
	cout << "[m1] = " << endl << m1 << endl << endl;

	Mat m2(3, 5, CV_8U, Scalar(50));
	cout << "[m2] = " << endl << m2 << endl << endl;
	Mat m_min, m_max;
	min(m1, 30, m_min);
	cout << "[m_min] = " << endl << m_min << endl << endl;
	max(m1, m2, m_max);
	cout << "[m_max] = " << endl << m_min << endl << endl;

	double minVal, maxVal;
	int minIdx[2] = {}, maxIdx[2] = {};
	Point minLoc, maxLoc;

	minMaxIdx(m1, &minVal, &maxVal, minIdx, maxIdx);
	cout << "m1의 최소값 = " << minVal << endl;
	cout << "최소값 좌표 = [" << minIdx[0] << "," << minIdx[1] << "]" << endl << endl;
	cout << "m1의 최대값 = " << maxVal << endl;
	cout << "최대값 좌표 = [" << maxIdx[0] << "," << maxIdx[1] << "]" << endl << endl;

	minMaxLoc(m1, 0, 0, &minLoc, &maxLoc);
	cout << "m1 최소값 좌표 = " << minLoc << endl;
	cout << "m1 최대값 좌표 = " << maxLoc << endl << endl;

	return 0;
}
