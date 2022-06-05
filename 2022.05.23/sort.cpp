#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	uchar data[] = { 
		21,15,10,9,
		14,6,10,25,
		15,61,10,12 };
	Mat m1(4, 4, CV_8U, data);
	Mat m_sort1, m_sort2, m_sort3;

	cv::sort(m1, m_sort1, SORT_EVERY_ROW);
	cv::sort(m1, m_sort2, SORT_EVERY_ROW + SORT_DESCENDING);
	cv::sort(m1, m_sort3, SORT_EVERY_COLUMN);

	cout << "[m1] = " << endl << m1 << endl << endl;
	cout << "[m_sort1] = " << endl << m_sort1 << endl << endl;
	cout << "[m_sort2] = " << endl << m_sort2 << endl << endl;
	cout << "[m_sort3] = " << endl << m_sort3 << endl << endl;

	sortIdx(m1, m_sort1, SORT_EVERY_ROW);
	cout << "[m_sort1_Idx] = " << endl << m_sort1 << endl;
	return 0;
}
