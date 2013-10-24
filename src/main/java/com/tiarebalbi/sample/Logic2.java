package com.tiarebalbi.sample;

import com.tiarebalbi.annotation.Runnable;

public class Logic2 {
	
	@Runnable
	public void executar() {
		for(int i = 0; i< 200;i++) {
			System.out.println("Rodou : " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
