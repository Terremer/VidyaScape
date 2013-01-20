package server.content.skills;

import server.Config;
import server.Server;
import core.util.Misc;
import server.event.Event;
import server.event.EventContainer;
import server.game.players.PlayerAssistant;
import server.event.EventManager;
import server.game.objects.Objects;
import server.game.players.Client;
import server.game.players.Player;

/**
 * @author Izumi
 **/

public class Fishing {
	
	private Client c;
	public Fishing(Client c) {
		this.c = c;
	}

public void FishingProcess() {
	boolean resetAnim = false;
        if (c.fishtimer > 0) {
            c.fishtimer--;
        }
		

        if (c.fishing && c.getItems().freeSlots() <= 0) {
            c.fishing = false;
            c.sendMessage("You need more free inventory spots to continue.");
            c.getPA().frame1();
	    resetAnim = true;
        }

        if (c.fishing && c.fishtimer <= 0 && c.getItems().freeSlots() > 0) {
            if (c.getItems().playerHasItem(c.fishitem)) {
                if (c.playerLevel[10] >= c.fishreqt) {
                    if (c.fishitem == 307 && !c.getItems().playerHasItem(313)) {
                        c.sendMessage("You need bait to fish here!");
                        c.fishing = false;
                    } else if (c.fishitem == 309 && !c.getItems().playerHasItem(314)) {
                       c.sendMessage("You need feathers to fish here!");
                        c.fishing = false;
					} else {
                        if (c.fishreq2 != 0 && c.playerLevel[10] >= c.fishreq2 && Misc.random(1) == 1) {
                            c.getItems().addItem(c.fishies2, 1);
                        c.getPA().addSkillXP(c.fishXP, 10);
                        } else {
                            c.getItems().addItem(c.fishies, 1);
                        c.getPA().addSkillXP(c.fishXP, 10);
                        }
                        if (c.fishitem == 307)
                        c.getPA().addSkillXP(c.fishXP, 10);
                        c.fishtimer = Misc.random(fishtime(c.fishies, c.fishreqt));   
                    }
                } else {
                    c.fishing = false;
                    c.sendMessage("You need a fishing level of " + c.fishreqt + " to fish here.");
					resetFishing();
                }
            } else {
                c.fishing = false;
               c.sendMessage("You need a " + c.getItems().getItemName(c.fishitem) + " to fish here.");
			   resetFishing();
            }
        }

        if (c.fishing) {
            c.startAnimation(c.fishemote);
			//c.stopMovement();
        }
	
	
	
      
	
		if (c.attemptingfish)
           if(c.clickObjectType > 0 && c.goodDistance(c.objectX + c.objectXOffset, c.objectY + c.objectYOffset, c.getX(), c.getY(), c.objectDistance)) {
                c.attemptingfish = false;
                c.fishing = true;
            }
	}
	public void Lol() {
	c.fishing = true;
        c.startAnimation(c.fishemote);
	return;
	}       
	
	 public int fishtime(int fish, int req) {
        int time = 10;
        if (fish == 317) {//Shrimp 1
            time = 10;
			c.sendMessage("You catch some raw shrimps.");
        }
		
        if (fish == 321) {//Anchovies 5
            time = 11;
			c.sendMessage("You catch some raw anchovies.");
        }
        if (fish == 327) {//Sardine 5
            time = 15;
			c.getItems().deleteItem(313, c.getItems().getItemSlot(313), 1);
			c.sendMessage("You catch a raw sardine.");
        }
        if (fish == 355) {//Trout 20
            time = 20;
			//c.getItems().deleteItem(314, c.getItems().getItemSlot(314), 1);  //not working WHY
			c.sendMessage("You catch a raw trout.");						 //not working WHY
        }
		if (fish == 331) {//salmon 30
            time = 20;
			c.getItems().deleteItem(314, c.getItems().getItemSlot(314), 1);  //not working WHY
			c.sendMessage("You catch a raw salmon.");						 //not working WHY
        }
        if (fish == 341) {//Cods 23
            time = 25;
			c.sendMessage("You catch a raw cod.");
        }
        if (fish == 349) {//Pike 25
            time = 28;
			c.sendMessage("You catch a raw pike.");
        }
        if (fish == 359) {//Tuna 35
            time = 30;
			c.sendMessage("You catch a raw tuna.");
			} else {
			if(c.fishies == 371) {
			time = 33;
			c.sendMessage("You catch a raw swordfish.");
			}
			}
        if (fish == 363) {//bass
            time = 35;
			c.sendMessage("You catch a raw bass.");
        }
        if (fish == 377) {//Lobsters 40
            time = 35;
			c.sendMessage("You catch a raw lobster.");
        }
        if (fish == 383) {//Sharks 79
            time = 40;
			c.sendMessage("You catch a raw shark.");
        }
        if (fish == 7944) { // Monkfish
        	time = 30;
        	c.sendMessage("You catch a monkfish.");
        }
        if (fish == 389) {//Manta ray 85
            time = 45;
			c.sendMessage("You catch a raw manta ray.");
        }
        int LevelXP = c.playerLevel[10] - req;
        if (LevelXP > req / 3)
            LevelXP = req / 3;
        time -= LevelXP;
        return time;
    }
	public void resetFishing() {
		this.c.fishies = -1;
		this.c.fishitem = -1;
		this.c.fishreqt = 0;
		c.fishing = false;
	}
}