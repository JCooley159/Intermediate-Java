using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SimpleCharts
{
    public partial class Form1 : Form
    {
        enum CharType
        {
            NONE,BAR,PIE
        }
       
        String[] aLabels;
        double[] adValues;
        CharType charType = CharType.NONE;

        public Form1()
        {
            InitializeComponent();
            this.CenterToScreen();
            textBoxLabels.Text = "January;February;March;April;May;June";
            textBoxValues.Text = "24;20;15;17;30;25";
            comboBoxChartType.Text = "Bar";
        }

        private void buttonDrawChart_Click(object sender, EventArgs e)
        {
            aLabels = textBoxLabels.Text.Split(';');
            String[] aValues = textBoxValues.Text.Split(';');
            adValues = Array.ConvertAll(aValues, Double.Parse);

            switch (comboBoxChartType.Text)
            {
                case "Bar": charType = CharType.BAR; break;
                case "Pie": charType = CharType.PIE; break;
            }
            
            Refresh();
        }

        //private void FloodFill(Bitmap bmp, Point pt, Color targetColor, Color replacementColor)
        //{
        //    Stack<Point> pixels = new Stack<Point>();
        //    targetColor = bmp.GetPixel(pt.X, pt.Y);
        //    pixels.Push(pt);

        //    while (pixels.Count > 0)
        //    {
        //        Point a = pixels.Pop();
        //        if (a.X < bmp.Width && a.X > 0 &&
        //                a.Y < bmp.Height && a.Y > 0)//make sure we stay within bounds
        //        {

        //            if (bmp.GetPixel(a.X, a.Y) == targetColor)
        //            {
        //                bmp.SetPixel(a.X, a.Y, replacementColor);
        //                pixels.Push(new Point(a.X - 1, a.Y));
        //                pixels.Push(new Point(a.X + 1, a.Y));
        //                pixels.Push(new Point(a.X, a.Y - 1));
        //                pixels.Push(new Point(a.X, a.Y + 1));
        //            }
        //        }
        //    }
        //    pictureBoxChart.Refresh(); //refresh our main picture box
        //    return;
        //}

        private void pictureBoxChart_Paint(object sender, PaintEventArgs e)
        {
            SolidBrush myBrush = new SolidBrush(System.Drawing.Color.Red);
            Rectangle rect;
            int w = pictureBoxChart.Width, h = pictureBoxChart.Height;
            Graphics g = e.Graphics;
            Font myFont = new Font("Arial", 16);
            Pen pen = new Pen(myBrush);
            Random r = new Random();

            switch (charType)
            {
                case CharType.BAR:     
                    
                    
                    myBrush = new SolidBrush(System.Drawing.Color.Red);
                    Color fillColor;
                    int iBarWidth = w / adValues.Length;
                    double dLargestValue = adValues.Max();

                    

                    for(int iBarCtr = 0; iBarCtr < adValues.Length; iBarCtr++) {
                        fillColor = Color.FromArgb(255, r.Next(0,255), r.Next(0,255), r.Next(0,255));
                        myBrush = new SolidBrush(fillColor);
                    
                        double dBarHeight = Convert.ToDouble(h) * adValues[iBarCtr] / dLargestValue; 
                        rect = new Rectangle(iBarWidth * iBarCtr, h - Convert.ToInt16(dBarHeight), iBarWidth, h);


                        g.FillRectangle(myBrush,rect);
                        g.DrawString(aLabels[iBarCtr], myFont, Brushes.White, new Point(iBarWidth * iBarCtr, h - 30));
                    }

                    charType = CharType.NONE;
                break;
                case CharType.PIE:                    
                    myBrush = new SolidBrush(System.Drawing.Color.Red);
                    rect = new Rectangle(10, 10, w-10, h-10);
                    double dTheta = 0, x0 = w/2, y0 = h/2, x1, y1;
                    int iTheta0, iTheta1;
                    double radius = Math.Sqrt((w - 20) * (w - 20) + (h - 20) * (h - 20));

                    //g.DrawEllipse(pen, rect);

                    for (int iBarCtr = aLabels.Length - 1; iBarCtr >= 0; iBarCtr--)
                    {
                        r = new Random();
                        Color fillColorPie = Color.FromArgb(255, r.Next(0, 255), r.Next(0, 255), r.Next(0, 255));
                        //Color fillColorPie = Color.FromArgb(255, 0, iBarCtr * 255 / adValues.Length, 0);
                        SolidBrush myBrushSlice = new SolidBrush(Color.FromArgb(255, 0, iBarCtr * 255 / adValues.Length, 0));
                        //SolidBrush myBrushSlice = new SolidBrush(fillColorPie);

                        dTheta = iBarCtr * 2.0 * Math.PI / adValues.Length;
                        iTheta0 = (iBarCtr-1) * 360 / adValues.Length;
                        iTheta1 = iBarCtr * 360 / adValues.Length;
                        x1 = x0 + radius * Math.Cos(dTheta);
                        y1 = y0 + radius * Math.Sin(dTheta);
                        //g.DrawLine(pen, new Point(Convert.ToInt32(x0), Convert.ToInt32(y0)), 
                        //                new Point(Convert.ToInt32(x1), Convert.ToInt32(y1)));

                        g.FillPie(myBrushSlice, rect, iTheta0, iTheta1);
                        //g.DrawPie(pen, rect, iTheta0, iTheta1);
                    }

                    charType = CharType.NONE;
                break;
            }
        }
    }
}
