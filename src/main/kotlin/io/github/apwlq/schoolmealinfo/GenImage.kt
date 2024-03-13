package io.github.apwlq.schoolmealinfo

/*
 * @author Bruce0203
 * @license MIT License
 */

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun genTimelineImage(lunch: String): File {
    val png = File("output/timeline_dist.png")
    AddTextToImgByTimeline.execute(File("assets/image/timeline.png"), lunch, png, date = getNowDate().split("")[1] + getNowDate().split("")[2] + getNowDate().split("")[3] + getNowDate().split("")[4] + "." + getNowDate().split("")[5] + getNowDate().split("")[6] + "." + getNowDate().split("")[7] + getNowDate().split("")[8] + ".")
    val jpg = File("output/timeline_dist.jpg")
    pngToJpg(png, jpg)
    return jpg
}

fun pngToJpg(png: File, jpg: File) {
    val beforeImg = ImageIO.read(png)
    val afterImg = BufferedImage(beforeImg.width, beforeImg.height, BufferedImage.TYPE_INT_RGB)
    afterImg.createGraphics().drawImage(beforeImg, 0, 0, Color.white, null)
    ImageIO.write(afterImg, "jpg", jpg)
}
