import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics; 
   
import java.util.Calendar;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;  

import java.awt.event.ActionListener;  
import javax.swing.Timer;  
import java.awt.event.ActionEvent;  

public class RelogioDigital extends JPanel {  
        String stringTime;  
        int hour, minute, second;  
        String aHour   = "";  
        String bMinute = "";  
        String cSecond = "";  

        public void setStringTime(String abc){this.stringTime = abc;} 
        public int getHora(){return hour;} 

        public RelogioDigital(){  
            Timer t = new Timer(1000, new ActionListener(){public void actionPerformed(ActionEvent e){repaint();}});  
            t.start();  
        }

        @Override  
        public void paintComponent(Graphics v) {  
            super.paintComponent(v);  
            Calendar calendario = Calendar.getInstance();  
            this.hour   = calendario.get(Calendar.HOUR_OF_DAY);  
            this.minute = calendario.get(Calendar.MINUTE);  
            this.second = calendario.get(Calendar.SECOND);  
            if(hour    < 10){this.aHour = "0";}  
            if(hour   >= 10){this.aHour = ""; }  
            if(minute  < 10){this.bMinute = "0";}  
            if(minute >= 10){this.bMinute = ""; }  
            if(second  < 10){this.cSecond = "0";}  
            if(second >= 10){this.cSecond = ""; }  
            setStringTime(aHour + hour + ":" + bMinute + minute + ":" + cSecond + second);  
            v.setColor(Color.BLACK);  
            Font Font1 = new Font("SansSerif", Font.PLAIN, 26);  
            v.setFont(Font1);  
            v.drawString(stringTime, 10, 25);  
        }

        @Override  
        public Dimension getPreferredSize(){return new Dimension(110, 30);}  
}   