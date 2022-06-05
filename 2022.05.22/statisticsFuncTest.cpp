#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat image = imread("./img/lenna_gray.bmp");

	Scalar sum_ = sum(image);
	cout << "[sum] = " << endl << sum_ << endl << endl;

	Scalar mean_ = mean(image);
	cout << "[mean] = " << endl << mean_ << endl << endl;

	Mat mask1(image.size(),CV_8U,Scalar(0));
	Mat mean_mask, stddev_mask;
	meanStdDev(image, mean_mask, stddev_mask, mask1);
	cout << "[mean_mask] = " << endl << mean_mask << endl << endl;
	cout << "[stddev_mask] = " << endl << stddev_mask << endl << endl;

	Mat m1 = (Mat_<uchar>(3,2) << 1,2,3,0,5,6);
	cout << "[m1] = " << endl << m1 << endl << endl;
	int count = countNonZero(m1);
	cout << "[countNonZero()] = " << count << endl << endl;

	Mat col_sum,row_sum;
	// REDUCE_SUM == 0
	// REDUCE_AVG == 1
	// REDUCE_MAX == 2
	// REDUCE_MIN == 3
	reduce(m1,col_sum, 0,0,CV_32F);
	cout << "[col_sum]" << endl << col_sum << endl << endl;
	reduce(m1, row_sum, 1, 0, CV_32F);
	cout << "[row_sum]" << endl << row_sum << endl << endl;
	return 0;
}
