#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat src = imread("./img/rose.bmp_std20.bmp");
	resize(src, src, Size(500, 500));
	imshow("Origin", src);
	
	Mat dst;
	int count = 1;
	for (int i = 3; i <= 15; i += 5) {
		String n = to_string(count++);
		blur(src, dst, Size(i, i));
		imshow("blurring"+n, dst);
	}

	waitKey(0);
	return 0;
}
