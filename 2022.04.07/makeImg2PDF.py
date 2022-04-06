from PIL import Image
import os

pathDir = "./imgs"
fileList = os.listdir(pathDir)

imgList = []

# rename
for idx,name in enumerate(fileList):
    dst = pathDir+"/"+str(idx) + '.jpg'
    namePath = pathDir+"/"+name
    os.rename(namePath,dst)
    
# append imgPath in imgList
imgPath = pathDir+"/"+fileList[0]
imBuf = Image.open(imgPath)
cvt_rgb0 = imBuf.convert('RGB')
for i in fileList:
    imgPath = pathDir+"/"+i
    imBuf = Image.open(imgPath)
    cvt_rgb0 = imBuf.convert('RGB')
    imgList.append(cvt_rgb0)

del imgList[0]
cvt_rgb0.save("./test.pdf",save_all=True,append_images=imgList)
