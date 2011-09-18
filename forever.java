import java.awt.*;
import java.awt.event.*;
public class forever {
	static int delay = 70;
	static int cur = -15066598;
	static int hold = 0;
	static int colorx = 649; static int colory = 204;
	static int xo = 649 - 18 * 4; static int yo = 204 + 18 * 19;
	static final int BLANK = -15066598;
	static final int ORANGE = -33243;
	static final int LINE = -13451526;
	static final int BLUE = -12294935;
	static final int YELLOW = -15835;
	static final int PURPLE = -2995027;
	static final int RED = -380326;
	static final int GREEN = -8596444;
	static boolean z = false;
	static boolean s = false;
	static boolean t = false;
	static boolean j = false;
	static boolean i = false;
	static boolean o = false;
	static boolean l = false;
	static int block = 0;
	static int bag = 1;
	static int diff = 0;
	static boolean holdnow = false;
	public static void main(String[] args) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.mouseMove(colorx, colory);
		robot.mouseMove(xo, yo);
		robot.setAutoDelay(delay); 
		do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
		while (block != 84) {
			if (cur != BLANK) {
				if (block % 7 == 0 && block > 0 && z && s && t && j && i && o && l) {
                                	z = false;
                                	s = false;
                                	t = false;
                                	j = false;
                                	i = false;
                               	 	o = false;
                                	l = false;
                                	diff += 3;
					if (bag == 2) diff = 2;
                                	bag++;
                                	System.out.println("NEW BAG " + bag);
                        	}
				if (used(cur) || holdnow) {
					if (holdnow) holdnow = false;
					hold(robot);
					do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
				}
				build(robot, cur);
				System.out.println(block + ":" + cur);
			}
			cur = getColor(robot, colorx, colory);
		}
		while (block != 112) {
			if (cur != BLANK) {
				if (block % 7 == 0 && block > 0 && z && s && t && j && i && o && l) {
                                        z = false;
                                        s = false;
                                        t = false;
                                        j = false;
                                        i = false;
                                        o = false;
                                        l = false;
                                        diff += 3;
                                        bag++;
                                        System.out.println("NEW BAG " + bag);
                                }
				if (used(cur)) {
					hold(robot);
					do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
				}
				leftstack(robot, cur);
				System.out.println(block + ":" + cur);
			}
			cur = getColor(robot, colorx, colory);
		}
		while (block != 140) {
                        if (cur != BLANK) {
                                if (block % 7 == 0 && block > 0 && z && s && t && j && i && o && l) {
                                        z = false;
                                        s = false;
                                        t = false;
                                        j = false;
                                        i = false;
                                        o = false;
                                        l = false;
                                        diff += 3;
                                        bag++;
                                        System.out.println("NEW BAG " + bag);
                                }
                                if (used(cur)) {
                                        hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                }
                                rightstack(robot, cur);
                                System.out.println(block + ":" + cur);
                        }
                        cur = getColor(robot, colorx, colory);
                }
	}
	public static boolean leftstack(Robot robot, int color) throws InterruptedException, AWTException {
		if (color == LINE) {
                        if (bag % 2 == 1) {
                                execute(robot, 1, 0);
                                i = true;
                                Thread.sleep(50);
                                block++;
                                return true;
                        } else {
                                execute(robot, 1, -1);
                                i = true;
                                Thread.sleep(50);
                                block++;
                                diff -= 4;
                                return true;
                        }
                }
		else if (color == BLUE) {
                        if (bag % 2 == 1) {
                                execute(robot, 3, 1);
                                j = true;
                                diff -= 1;
                        } else {
                                execute(robot, 1, 0);
                                j = true;
                                diff -= 3;
                        }
                }
		else if (color == ORANGE) {
                        if (bag % 2 == 1) {
                                execute(robot, 1, -2);
                                l = true;
                        } else {
                                execute(robot, 3, -1);
                                l = true;
                        }
                }
                else if (color == YELLOW) {
                        execute(robot, 0, -4);
                        o = true;
                }
		else if (color == GREEN) {
                        if (bag % 4 == 0 && bag > 0) {
                                execute(robot, 1, 2);
                                s = true;
                        }
                        if (bag % 4 == 1) {
				if (t) {
                                	execute(robot, 1, 4);
                                	s = true;
				} else {
					hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
				}
                        }
			if (bag % 4 == 2) {
				execute(robot, 1, 4);
				s = true;
			}
                        if (bag % 4 == 3) {
				execute(robot, 1, 2);
				s = true;
                        }
                }
		else if (color == PURPLE) {
                        if (bag % 4 == 0 && bag > 0) {
                                if (s && z) {
                                        execute(robot, 2, 3);
                                        t = true;
                                } else {
                                        hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
                                }
                        }
                        if (bag % 4 == 3) {
                                execute(robot, 3, 5);
                                t = true;
                        }
                        if (bag % 4 == 2) {
                                if (s && z) {
                                        execute(robot, 1, 2);
                                        t = true;
                                } else {
                                        hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
                                }
                        }
                        if (bag % 4 == 1) {
                                if (!z) {
                                        execute(robot, 0, 4);
                                        t = true;
                                } else {
                                        rotate(robot, 3);
                                        move(robot, 5);
                                        softdrop(robot, xo + 9 * 18, yo, PURPLE, KeyEvent.VK_UP);
                                        t = true;
                                }
                        }
                }
		else if (color == RED) {
                        if (bag % 4 == 0 && bag > 0) {
                                execute(robot, 1, 4);
                                z = true;
                        }
                        if (bag % 4 == 3) {
				if (t) {
                                	execute(robot, 1, 4);
                                	z = true;
				} else {
					hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
				}
                        }
                        if (bag % 4 == 2) {
                                execute(robot, 1, 2);
                                z = true;
                        }
                        if (bag % 4 == 1) {
                                execute(robot, 1, 2);
                                z = true;
                        }
                }
                block++;
                return true;
	}		
	public static boolean rightstack(Robot robot, int color) throws InterruptedException, AWTException {
		if (color == LINE) {
                        if (bag % 2 == 1) {
                                execute(robot, 1, 0);
                                i = true;
                                Thread.sleep(50);
                                block++;
                                return true;
                        } else {
                                execute(robot, 1, -1);
                                i = true;
                                Thread.sleep(50);
                                block++;
				diff -= 4;
                                return true;
                        }
                }
		else if (color == ORANGE) {
			if (bag % 2 == 1) {
				execute(robot, 1, 2);
				l = true;
			} else {
				execute(robot, 3, 3);
				l = true;
			}
		}
		else if (color == YELLOW) {
			execute(robot, 0, 4);
			o = true;
		}
		else if (color == BLUE) {
			if (bag % 2 == 1) {
				execute(robot, 3, 1);
				j = true;
				diff -= 1;
			} else {
				execute(robot, 1, 0);
				j = true;
				diff -= 3;
			}
		}
		else if (color == GREEN) {
                        if (bag % 4 == 0 && bag > 0) {
                                execute(robot, 1, -4);
                                s = true;
                        }
                        if (bag % 4 == 1 || bag % 4 == 2) {
                                execute(robot, 1, -2);
                                s = true;
                        }
                        if (bag % 4 == 3) {
                                if (t) {
                                        execute(robot, 1, -4);
                                        s = true;
                                } else {
                                        hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
                                }
                        }
                }
		else if (color == PURPLE) {
                        if (bag % 4 == 0 && bag > 0) {
                                if (s && z) {
                                        execute(robot, 2, -2);
                                        t = true;
                                } else {
                                        hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
                                }
                        }
                        if (bag % 4 == 3) {
                                execute(robot, 1, -4);
                                t = true;
                        }
                        if (bag % 4 == 2) {
                                if (s && z) {
                                        execute(robot, 3, -1);
                                        t = true;
                                } else {
                                        hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
                                }
                        }
                        if (bag % 4 == 1) {
                                if (!s) {
                                        execute(robot, 0, -3);
                                        t = true;
                                } else {
                                        rotate(robot, 1);
                                        move(robot, -4);
                                        softdrop(robot, xo, yo, PURPLE, KeyEvent.VK_Z);
                                        t = true;
                                }
                        }
                }
		else if (color == RED) {
                        if (bag % 4 == 0 && bag > 0) {
                                execute(robot, 1, -2);
                                z = true;
                        }
                        if (bag % 4 == 3) {
                                execute(robot, 1, -2);
                                z = true;
                        }
                        if (bag % 4 == 2) {
                                execute(robot, 1, -4);
                                z = true;
                                if (bag == 2 && s && i) diff -= 1;
                        }
                        if (bag % 4 == 1) {
                                if (!t) {
                                        hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
                                } else {
                                        execute(robot, 1, -4);
                                        z = true;
                                }
                        }
                }
		block++;
		return true;
	}
	public static boolean build(Robot robot, int color) throws InterruptedException, AWTException {
		if (color == LINE) {
			if (bag % 2 == 1) {
				execute(robot, 1, -1);
				i = true;
				Thread.sleep(50);
				block++;
				return true;
			} else {
				if (bag == 2) {
					if (o && j && l && s && z) diff -= 4;
					else if (s) diff -= 3;
					else diff -= 2;
				} else {
					diff -= 4;
				}
				execute(robot, 1, 0);
				i = true;
				Thread.sleep(50);
				block++;
				return true;
			}
		}
		else if (color == GREEN) {
			if (bag % 4 == 0 && bag > 0) {
				execute(robot, 1, -4);
				s = true;
			}
			if (bag % 4 == 1 || bag % 4 == 2) {
				execute(robot, 1, -2);
				s = true;
			}
			if (bag == 2 && i && s) diff -= 2;
			if (bag == 2 && i && !s) diff -= 1;
			if (bag % 4 == 3) {
				if (t) {
					execute(robot, 1, -4);
					s = true;
				} else {
					hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
				}
			}
		}
		else if (color == PURPLE) {
			if (bag % 4 == 0 && bag > 0) {
				if (s && z) {
					execute(robot, 2, -2);
					t = true;
				} else {
					hold(robot);
                                        do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
				}
			}
			if (bag % 4 == 3) {
				execute(robot, 1, -4);
				t = true;
			}
			if (bag % 4 == 2) {
				if (s && z) {
					execute(robot, 3, -1);
					t = true;
				} else {
					hold(robot);
					do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
                                        return false;
				}
			}
			if (bag % 4 == 1) {
				if (!s) {
					execute(robot, 0, -3);
					t = true;
				} else {
					rotate(robot, 1);
					move(robot, -4);
					softdrop(robot, xo, yo, PURPLE, KeyEvent.VK_Z);
					t = true;
				}
			}
		}
		else if (color == RED) {
			if (bag % 4 == 0 && bag > 0) {
				execute(robot, 1, -2);
				z = true;
			}
			if (bag % 4 == 3) {
				execute(robot, 1, -2);
				z = true;
			}
			if (bag % 4 == 2) {
				execute(robot, 1, -4);
				z = true;
				if (bag == 2 && s && i) diff -= 1;
			}
			if (bag % 4 == 1) {
				if (!t) {
					hold(robot);
					do {cur = getColor(robot, colorx, colory);} while (cur == BLANK);
					return false;
				} else {
					execute(robot, 1, -4);
					z = true;
				}
			}
		}
		else if (color == YELLOW) {
			if ((!l && !j) || (l && j)) {
				execute(robot, 0, 3);
				o = true;
			} else if (j) {
				move(robot, 4);
				softdrop(robot, xo + 9 * 18, yo, YELLOW, KeyEvent.VK_LEFT);
				o = true;
			} else {
				move(robot, 2);
				softdrop(robot, xo + 6 * 18, yo, YELLOW, KeyEvent.VK_RIGHT);
				o = true;
			}
		}
		else if (color == ORANGE) {
			if (o) {
				execute(robot, 3, 5);
				l = true;
			} else if (j) {
				execute(robot, 1, 2);
				l = true;
			} else {
				if (seenext(robot) == YELLOW) {
					execute(robot, 3, 5);
					l = true;
				} else {
					execute(robot, 1, 2);
					l = true;
				}
			}
		}
					 
		else if (color == BLUE) {
			if (o) {
				execute(robot, 1, 2);
				j = true;
			} else if (l) {
				execute(robot, 3, 5);
				j = true;
			} else {
				if (seenext(robot) == YELLOW) {
					execute(robot, 1, 2);
					j = true;
				} else {
					execute(robot, 3, 5);
					j = true;
				}
			}
		}
					
		block++;
		return true;
	}
	public static boolean used(int color) {
		if (color == RED) return z;
		if (color == GREEN) return s;
		if (color == BLUE) return j;
		if (color == ORANGE) return l;
		if (color == YELLOW) return o;
		if (color == PURPLE) return t;
		if (color == LINE) return i;
		return false;
	}
	public static int seenext(Robot robot) throws AWTException, InterruptedException{
		int x = 810;
		int y = 340;
		int next = getColor(robot, x, 262);
		robot.mouseMove(x, 262);
		System.out.println("HOLD: " + hold);
		if (hold == BLUE || hold == YELLOW || hold == ORANGE) {
			holdnow = true;
			return hold;
		}
		if (next == -3709) return YELLOW;
		if (next == BLUE || next == ORANGE) return getColor(robot, x, 262);
		for (int i = 0; i < 4; i++) {
			robot.mouseMove(x, y + 55 * i);
			int color = getColor(robot, x, y + 55 * i);
			System.out.println(color);
			if (color == -5781) {
				return YELLOW;
			}
			if (color == BLUE || color == ORANGE) {
				return color;
			}
		}
		System.out.println("WTF");
		return -1;
	}	 	
	public static void execute(Robot robot, int r, int m) throws InterruptedException, AWTException{
		rotate(robot, r);
		move(robot, m);
		harddrop(robot);
	}	
	public static void harddrop(Robot robot) throws InterruptedException, AWTException{
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
	}
	public static void rotate(Robot robot, int spaces) throws InterruptedException, AWTException{
		for (int i = 0; i < spaces; i++) {
                        robot.keyPress(KeyEvent.VK_UP);
                        robot.keyRelease(KeyEvent.VK_UP);
		}
	}
	public static void move(Robot robot, int spaces) throws InterruptedException, AWTException{
		if (spaces > 0) {
			for (int i = 0; i < spaces; i++) {
				robot.keyPress(KeyEvent.VK_RIGHT);
				robot.keyRelease(KeyEvent.VK_RIGHT);
			}
		}
		else if (spaces < 0) {
			for (int i = 0; i > spaces; i--) {
                                robot.keyPress(KeyEvent.VK_LEFT);
                                robot.keyRelease(KeyEvent.VK_LEFT);
			}
		}
	}
	public static void hold(Robot robot) throws InterruptedException, AWTException{
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(50);
		hold = cur;
	}
	public static int getColor(Robot robot, int x, int y) throws AWTException{
		return robot.getPixelColor(x, y).getRGB();
	}
	public static void softdrop(Robot robot, int x, int y, int breakcolor, int action) throws InterruptedException, AWTException{
		if (diff < 0) diff = 0;
		robot.mouseMove(x, y - diff * 18);
		robot.keyPress(KeyEvent.VK_DOWN);
		while (getColor(robot, x, y - diff * 18) != breakcolor) {
			Thread.sleep(delay);
		}
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(delay);
		robot.keyPress(action);
		Thread.sleep(delay);
		robot.keyRelease(action);
		harddrop(robot);
	}	
}
