#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat src = imread("./img/cat1.jpg");
	resize(src, src, Size(823, 503));
	imshow("Orgin", src);

	// 이동 
	double data1[] = {
		1,0,30,
		0,1,50
	}; // x -> 30 , y -> 50 만큼 이동

	Mat M = Mat(2, 3, CV_64FC1, data1);

	Mat trans;
	warpAffine(src, trans, M, Size());
	imshow("Translation Transformation, x->30, y->50", trans);

	// 전단 
	double data2[] = {
		1,0.4,0,
		0.4,1,0
	}; // x->0 , y->0 , x,y 0.4씩 밀기
	M = Mat(2, 3, CV_64FC1, data2);
	Mat shear;
	warpAffine(src, shear, M, src.size()+Size(200,330));
	imshow("Shear Transformation, x->0, y->0, shear 0,4", shear);

	// 크기 
	Mat scal;
	double data3[] = {
		1.0,0,0,
		0,1.5,0
	};
	M = Mat(2, 3, CV_64FC1, data3);
	warpAffine(src, scal, M, src.size());
	imshow("Scaling X=1.0 Y=1.5", scal);
	// 회전 

	Mat rotat;
	float cx = src.cols / 2.0;
	float cy = src.rows / 2.0;
	double theta = 30;
	M = getRotationMatrix2D(Point(cx, cy), theta, 1);
	warpAffine(src, rotat, M, src.size());
	imshow("Rotation Transformation roatate => 30", rotat);

	// 대칭변환 

	Mat mirr;
	flip(src, mirr, 1);
	imshow("Mirroring Transformation, reverse left and right", mirr);

	waitKey(0);
	destroyAllWindows();
	return 0;
}
