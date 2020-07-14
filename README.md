# Proyecto_Final
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Main{


public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					Main_Gral dialog = new Main_Gral();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
