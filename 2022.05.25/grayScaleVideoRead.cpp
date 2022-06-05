#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat gray_img = imread("./img/catbread.jpg",IMREAD_GRAYSCALE);
	imshow("gray_img", gray_img);

	Mat img2(480, 640, CV_8UC1, Scalar(0));
	gray_img.copyTo(img2);
	imshow("img2", img2);

	Mat img3 = imread("./img/catbread.jpg");
	Mat img4;
	cvtColor(img3, img4, COLOR_BGR2GRAY);
	imshow("img4", img4);
  
	waitKey(0);
	return 0;
}
