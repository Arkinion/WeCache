/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wecache.GUIs;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JWindow;
import javax.swing.JPanel;

public class SplashScreen
{
    
    private SplashScreen() throws Exception
    {
        throw new Exception("SplashScreen cannot be instantiated.");
    }

    private static final JWindow splashScreen = new JWindow();

    public static void showSplash()
    {

        JPanel content = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                Image img = new ImageIcon("splash.png").getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            }
        };
        double hWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double hHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        splashScreen.setContentPane(content);
        
        splashScreen.setBounds(((int)hWidth)/2-(320), (((int)hHeight)/2-235), 640, 470);
        splashScreen.setVisible(true);

    }

    public static void hideSplash()
    {

        splashScreen.setVisible(false);

    }
}