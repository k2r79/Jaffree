package com.github.kokorin.jaffree;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class FFmpegProgressTest {
    @Test
    public void fromStringWhenCopingCodecs() throws Exception {
        String value = "frame= 5012 fps=25.1 q=-1.0 Lsize=   26463kB time=00:02:47.20 bitrate=1296.6kbits/s speed=1.23e+003x";
        FFmpegProgress result = FFmpegProgress.fromString(value);

        Assert.assertNotNull(result);
        Assert.assertEquals(5012, result.getFrame());
        Assert.assertEquals(25.1, result.getFps(), 0.01);
        Assert.assertEquals(-1.0, result.getQ(), 0.01);
        Assert.assertEquals(26_463_000 * 8, result.getSize());
        Assert.assertEquals(167_200, result.getTime());
        Assert.assertEquals(1296.6, result.getBitrate(), 0.01);
        Assert.assertEquals(1.23e+3, result.getSpeed(), 0.1);
    }

    @Test
    public void fromStringWhenCopingCodecs2() throws Exception {
        String value = "frame=   33 fps=0.0 q=-1.0 Lsize=      71kB time=00:00:02.79 bitrate= 207.3kbits/s speed=11.9x   ";
        FFmpegProgress result = FFmpegProgress.fromString(value);

        Assert.assertNotNull(result);
        Assert.assertEquals(33, result.getFrame());
        Assert.assertEquals(0.0, result.getFps(), 0.01);
        Assert.assertEquals(-1.0, result.getQ(), 0.01);
        Assert.assertEquals(71_000 * 8, result.getSize());
        Assert.assertEquals(2_790, result.getTime());
        Assert.assertEquals(207.3, result.getBitrate(), 0.01);
        Assert.assertEquals(11.9, result.getSpeed(), 0.1);
    }

    @Test
    @Ignore("This output string appeared, but I can reproduce it")
    public void testFromStringWhenEncoding() throws Exception {
        String value = "frame=  184 fps=0.0 q=-1.0 Lsize=      38kB time=00:00:07.24 bitrate=  43.4kbits/s dup=73 drop=0 speed=19.5x";
        FFmpegProgress result = FFmpegProgress.fromString(value);

        Assert.assertNotNull(result);
        Assert.assertEquals(5012, result.getFrame());
        Assert.assertEquals(25.1, result.getFps(), 0.01);
        Assert.assertEquals(-1.0, result.getQ(), 0.01);
        Assert.assertEquals(26_463_000 * 8, result.getSize());
        Assert.assertEquals(167_200, result.getTime());
        Assert.assertEquals(1296.6, result.getBitrate(), 0.01);
        Assert.assertEquals(1.23e+3, result.getSpeed(), 0.1);
    }
}