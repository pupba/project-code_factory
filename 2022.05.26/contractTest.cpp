#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat img = imread("./img/catbread.jpg");
	resize(img, img, Size(500, 500));

	imshow("origin", img);
	double alpha = 0.5, beta = -0.5;
	Mat conUp, conDown;
	// conUp = img + (alpha * (img - 128));
	// conDown = img + (beta * (img - 128));
	double a = 1 + alpha;
	double b = 128 * alpha;
	conUp = a * img - b;
	imshow("Up_0.5 contract", conUp);
	
	a = 1 + beta; 
	b = 128 * beta;
	conDown = a * img - b;
	imshow("Down_0.5 contract", conDown);

	waitKey(0);
	return 0;
}
