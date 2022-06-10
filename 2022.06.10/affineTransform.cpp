#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat src = imread("./img/cat1.jpg");
	resize(src, src, Size(823, 503));
	imshow("Orgin", src);

	Point2f srcPts[3], dstPts[3];
	srcPts[0] = Point2f(0, 0);
	srcPts[1] = Point2f(src.cols - 1, 0);
	srcPts[2] = Point2f(src.cols - 1, src.rows - 1);
	dstPts[0] = Point2f(10, 10);
	dstPts[1] = Point2f(src.cols - 100, 100);
	dstPts[2] = Point2f(src.cols - 50, src.rows - 50);

	Mat res = getAffineTransform(srcPts, dstPts);

	Mat dst;
	warpAffine(src, dst, res, src.size());
	imshow("Afiine Transform", dst);

	waitKey(0);
	destroyAllWindows();
	return 0;
}
