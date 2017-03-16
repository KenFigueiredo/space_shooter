package com.wcfjb.spaceshooter.framework;

import com.wcfjb.spaceshooter.framework.Graphics.ImageFormat;

public interface Image {
	
    public int getWidth();
    
    public int getHeight();
    
    public ImageFormat getFormat();
    
    public void dispose();
}
