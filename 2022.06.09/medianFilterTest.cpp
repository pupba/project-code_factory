#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

Mat saltPepper(Mat org, float percent) {
	Mat dst;
	org.copyTo(dst);

	int nNoise = (int)(dst.cols * dst.rows * percent);
	for (int i = 0; i < nNoise; i++) {
		int c = rand() % dst.cols;
		int r = rand() % dst.rows;
		dst.at<uchar>(r, c) = (i % 2) * 255;
	}
	return dst;
}

int main()
{
	Mat src = imread("./img/cat1.jpg",IMREAD_GRAYSCALE);
	resize(src, src, Size(500, 500));
	imshow("Origin", src);

	Mat spImg = saltPepper(src,0.1);
	imshow("SaltPepper 10%", spImg);

	Mat dst;
	medianBlur(spImg, dst, 3); // 3 X 3
	imshow("MedianFilter 3 X 3", dst);

	waitKey(0);
	return 0;
}
