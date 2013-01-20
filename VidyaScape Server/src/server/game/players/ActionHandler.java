package server.game.players;

import server.Config;


import server.content.skills.*;
import server.Server;
import server.game.objects.Object;
import core.util.Misc;
import core.util.ScriptManager;

public class ActionHandler {
	
	private Client c;
	
	public ActionHandler(Client Client) {
		this.c = Client;
	}
	
	
	public void firstClickObject(int objectType, int obX, int obY) {
		c.clickObjectType = 0;
		if (Woodcutting.playerTrees(c, objectType)) {
			Woodcutting.attemptData(c, objectType, obX, obY);
			return;
		}
		if (Mining.miningRocks(c, objectType)) {
			Mining.attemptData(c, objectType, obX, obY);
			return;
		}
		switch(objectType) {
		case 2465:   //air altar return portal
			c.teleportToX = 2987;
			c.teleportToY = 3293;
			c.heightLevel = 0;
		break;
		case 2467:   //water altar return portal
			c.teleportToX = 3183;
			c.teleportToY = 3164;
			c.heightLevel = 0;
		break;
		case 2469:   //fire altar return portal
			c.teleportToX = 3312;
			c.teleportToY = 3252;
			c.heightLevel = 0;
		break;
		case 2468:   //earth altar return portal
			c.teleportToX = 3304;
			c.teleportToY = 3474;
			c.heightLevel = 0;
		break;
		case 60: //ladder
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
		break;
		case 2796: //ladder
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
		break;
		case 2797: //ladder
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel-1);
		break;
		case 2833: //ladder
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
		break;
		case 9582: //spiral stairs up
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
		break;
		case 9584: //spiral stairs down
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel-1);
		break;
		case 4772:    //bamboo ladder fix
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
		break;
		case 4778:    //bamboo ladder fix
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel-1);
		break;
		case 1738: 
        //c.startAnimation(828);
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, 1);
        break;
		case 1739:
		c.getPA().turnTo(obX,obY);
        //c.startAnimation(828);
        c.getPA().movePlayer(c.absX, c.absY, 2);
        break;
		case 1740:
		c.getPA().turnTo(obX,obY);
        //c.startAnimation(828);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel-1);
        break;
		case 1746: 
        //c.startAnimation(828);
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel-1);
        break;
		case 1747:
		c.getPA().turnTo(obX,obY);
        c.startAnimation(828);
        c.getPA().movePlayer(c.absX, c.absY, c.heightLevel+1);
        break;
		case 1748: 
		c.getPA().turnTo(obX,obY);
        c.startAnimation(828);
        c.getPA().movePlayer(c.absX, c.absY, 2);
        break;
		case 1754: //Heroes Guild cave ladder down
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(2893, 9907, 0);
		break;
		case 1757: //Heroes Guild cave ladder up
		c.getPA().turnTo(obX,obY);
        c.getPA().movePlayer(2893, 3507, 0);
		break;
		case 2561:
			c.getThieving().stealFromStall(2561,50,5);
		break;
		case 2565:
			c.getThieving().stealFromStall(2565,50,50);
		break;
		case 2560:
			c.getThieving().stealFromStall(2560,50,20);
		break;
		case 2562:
			c.getThieving().stealFromStall(2562,50,75);
		break;
		case 2563:
			c.getThieving().stealFromStall(2563,50,35);
		break;
		case 2564:
			c.getThieving().stealFromStall(2564,50,65);
		break;
		case 2646:
			if(System.currentTimeMillis() - c.buryDelay > 1500) {	
			c.getItems().addItem(1779,1);
			c.turnPlayerTo(c.objectX, c.objectY);	
			c.startAnimation(2292);
			c.getPA().object(-1, 2739, 3444, 0, 10);	
			c.sendMessage("You pick some flax.");
				c.buryDelay = System.currentTimeMillis();
				
			
			}	
			break;
		/*
		 * Agility
		 */
		case 2288:
			break;
		case 2309:
			if (c.getX() == 2998 && c.getY() == 3916) {
				c.getAgil().doWildernessEntrance(c);
			}
			break;
		case 2295:
			if (c.getX() == 2474 && c.getY() == 3436) {
				c.getAgil().doGnomeLog(c);
			}
			break;
		case 2285: //NET1
			c.getAgil().doGnomeNet1(c);
				break;
		case 2313: //BRANCH1
			c.getAgil().doGnomeBranch1(c);
				break;
		case 2312: //ROPE
			if (c.getX() == 2477 && c.getY() == 3420) {
				c.getAgil().doGnomeRope(c);
			}
				break;
			case 2314: //BRANCH2
			c.getAgil().doGnomeBranch2(c);
				break;
			case 2286: //NET2
			c.getAgil().doGnomeNet2(c);
				break;
			case 154: //PIPE1
				if (c.getX() ==  2484 && c.getY() == 3430) {
					c.getAgil().doGnomePipe1(c);
				}
				break;
			case 4058: //PIPE2
				if (c.getX() == 2487 && c.getY() == 3430) {
					c.getAgil().doGnomePipe2(c);
				}
				break;
		/*
		 * END OF AGILITY
		 * 
		 * */
		case 9294:
			if (c.objectX == 2879 && c.objectY == 9813) {
			}
			break;
		case 9293:
			if (c.objectX == 2887 && c.objectY == 9799) {
				c.getPA().movePlayer(2892, 9799, 0);
			}
			if (c.objectX == 2890 && c.objectY == 9799) {
				c.getPA().movePlayer(2886, 9799, 0);
			}
			break;
		case 1568:
			if (c.objectX == 3097 && c.objectY == 3468) {
				c.getPA().movePlayer(3117, 9852, 0);
			}
			break;
		case 1755:
			if (c.objectX == 2884 && c.objectY == 9797) {
				c.getPA().movePlayer(2844, 3516, 0);
			}
			if (c.objectX == 3116 && c.objectY == 9852) {
				c.getPA().movePlayer(3096, 3468, 0);
			}
		case 2178:
			if (c.objectX == 2675 && c.objectY == 3170) {
				c.getDH().sendDialogues(79, 0);
			}
			break;
		case 3044:
		case 2781:
			System.out.println("al karhid furnace, HAI");
			c.getSmithing().sendSmelting();
		break;
		case 2:
			c.getPA().movePlayer(3029, 9582, 0);
			break;
			/* Shops */
		
		case 6839:
			c.getShops().openShop(9);
			c.sendMessage("As you look down in the chest, you see a small monkey with a money-pouch");
			c.sendMessage("next to him. I think there is where I should put the coins.");
			break;
			
			/* Bank */
		case 2213:
			c.getDH().sendDialogues(1000, 494);
		break;
		case 11758:  //fally bank function
			c.getPA().openUpBank();
		break;

		case 2492:
			if (c.objectX == 2889 && c.objectY == 4813) {
				c.getPA().startTeleport(3252, 3401, 0, "modern");
			}
			break;
		case 9356:
			c.getPA().enterCaves();
			c.sendMessage("Good luck!");
		break;

                case 2557:
                     if(c.getItems().playerHasItem(1523, 1) && c.absX == 3190 && c.absY == 3957) {
                        c.getPA().movePlayer(3190, 3958, 0);
                     } else if(c.getItems().playerHasItem(1523, 1) && c.absX == 3190 && c.absY == 3958) {
                        c.getPA().movePlayer(3190, 3957, 0);
                     }
                break;

                case 2995:
                       c.getPA().startTeleport2(2717, 9801, 0);
                       c.sendMessage("Welcome to the dragon lair, be aware. It's very dangerous.");
                break;

		case 1816:
			c.getPA().startTeleport2(2271, 4680, 0);			
		break;
		case 1817:
			c.getPA().startTeleport(3067, 10253, 0, "modern");
		break;
		case 1814:
			//ardy lever
			c.getPA().startTeleport(3153, 3923, 0, "modern");
		break;

		case 2882:
		case 2883:
			if (c.objectX == 3268) {
				if (c.absX < c.objectX) {
					c.getPA().walkTo(1,0);
				} else {
					c.getPA().walkTo(-1,0);
				}
			}
		break;

		case 1765:
			c.getPA().movePlayer(3067, 10256, 0);
		break;
		case 272:
		c.getPA().movePlayer(c.absX, c.absY, 1);
		break;
		
		case 273:
		c.getPA().movePlayer(c.absX, c.absY, 0);
		break;

		case 245:
		c.getPA().movePlayer(c.absX, c.absY + 2, 2);
		break;

		case 246:
		c.getPA().movePlayer(c.absX, c.absY - 2, 1);
		break;

		case 1766:
		c.getPA().movePlayer(3016, 3849, 0);
		break;

		case 6552:
		if (c.playerMagicBook == 0) {
                        c.playerMagicBook = 1;
                        c.setSidebarInterface(6, 12855);
                        c.autocasting = false;
                        c.sendMessage("An ancient wisdomin fills your mind.");
                        c.getPA().resetAutocast();
		} else {
			c.setSidebarInterface(6, 1151); //modern
			c.playerMagicBook = 0;
                        c.autocasting = false;
			c.sendMessage("You feel a drain on your memory.");
			c.autocastId = -1;
			c.getPA().resetAutocast();
		}	
		break;
		

		case 1733:
			c.getPA().movePlayer(c.absX, c.absY + 6393, 0);
		break;
		
		case 1734:
			c.getPA().movePlayer(c.absX, c.absY - 6396, 0);
		break;
		
		case 9357:
			c.getPA().resetTzhaar();
		break;
		
		case 8959:
			if (c.getX() == 2490 && (c.getY() == 10146 || c.getY() == 10148)) {
				if (c.getPA().checkForPlayer(2490, c.getY() == 10146 ? 10148 : 10146)) {
					new Object(6951, c.objectX, c.objectY, c.heightLevel, 1, 10, 8959, 15);	
				}			
			}
		break;

		
		case 10177:
			c.getPA().movePlayer(1890, 4407, 0);
		break;
		case 10230:
			c.getPA().movePlayer(2900, 4449, 0);
		break;
		case 10229:
			c.getPA().movePlayer(1912, 4367, 0);
		break;

		case 2623:
			if (c.absX >= c.objectX)
				c.getPA().walkTo(-1,0);
			else
				c.getPA().walkTo(-1,0);
		break;
		//pc boat
		case 14315:
			c.getPA().movePlayer(2661,2639,0);
		break;
		case 14314:
			c.getPA().movePlayer(2657,2639,0);
		break;
		
		case 1596:
		case 1597:
		if (c.getY() >= c.objectY)
			c.getPA().walkTo(0,-1);
		else
			c.getPA().walkTo(0,1);
		break;
		
		case 14235:
		case 14233:
			if (c.objectX == 2670)
				if (c.absX <= 2670)
					c.absX = 2671;
				else
					c.absX = 2670;
			if (c.objectX == 2643)
				if (c.absX >= 2643)
					c.absX = 2642;
				else
					c.absX = 2643;
			if (c.absX <= 2585)
				c.absY += 1;
			else c.absY -= 1;
			c.getPA().movePlayer(c.absX, c.absY, 0);
		break;
		
		case 14829: case 14830: case 14827: case 14828: case 14826: case 14831:
			//Server.objectHandler.startObelisk(objectType);
			Server.objectManager.startObelisk(objectType);
		break;
		
		case 9369:
			if (c.getY() > 5175)
				c.getPA().movePlayer(2399, 5175, 0);
			else
				c.getPA().movePlayer(2399, 5177, 0);
		break;
		
		//barrows
		//Chest
		case 10284:
			//c.shakeScreen(3, 2, 3, 2);
			if(c.barrowsKillCount < 5) {
				c.sendMessage("You must kill all the brothers to receive a reward!");
			}
			if(c.barrowsKillCount == 5 && c.barrowsNpcs[c.randomCoffin][1] == 1) {
				c.sendMessage("I have already awakened this brother.");
			}
			if(c.barrowsNpcs[c.randomCoffin][1] == 0 && c.barrowsKillCount >= 5) {
				Server.npcHandler.spawnNpc(c, c.barrowsNpcs[c.randomCoffin][0], 3551, 9694-1, 0, 0, 120, 30, 200, 200, true, true);
				c.barrowsNpcs[c.randomCoffin][1] = 1;
			}
			if((c.barrowsKillCount > 5 || c.barrowsNpcs[c.randomCoffin][1] == 2) && c.getItems().freeSlots() >= 2) {
				c.resetShaking();
				c.getPA().resetBarrows();
				c.getItems().addItem(c.getPA().randomRunes(), Misc.random(150) + 100);
				if (Misc.random(2) == 1)
					c.getItems().addItem(c.getPA().randomBarrows(), 1);
				c.getPA().startTeleport(3564, 3288, 0, "modern");
			} else if(c.barrowsKillCount > 5 && c.getItems().freeSlots() <= 1) {
				c.sendMessage("You need two empty slots in your inventory to receive the reward.");
			}
			break;
		//doors
		case 6749:
			if(obX == 3562 && obY == 9678) {
				c.getPA().object(3562, 9678, 6749, -3, 0);
				c.getPA().object(3562, 9677, 6730, -1, 0);
			} else if(obX == 3558 && obY == 9677) {
				c.getPA().object(3558, 9677, 6749, -1, 0);
				c.getPA().object(3558, 9678, 6730, -3, 0);
			}
			break;
		case 6730:
			if(obX == 3558 && obY == 9677) {
				c.getPA().object(3562, 9678, 6749, -3, 0);
				c.getPA().object(3562, 9677, 6730, -1, 0);
			} else if(obX == 3558 && obY == 9678) {
				c.getPA().object(3558, 9677, 6749, -1, 0);
				c.getPA().object(3558, 9678, 6730, -3, 0);
			}
			break;
		case 6727:
			if(obX == 3551 && obY == 9684) {
				c.sendMessage("You can't open this door...");
			}
			break;
		case 6746:
			if(obX == 3552 && obY == 9684) {
				c.sendMessage("You can't open this door...");
			}
			break;
		case 6748:
			if(obX == 3545 && obY == 9678) {
				c.getPA().object(3545, 9678, 6748, -3, 0);
				c.getPA().object(3545, 9677, 6729, -1, 0);
			} else if(obX == 3541 && obY == 9677) {
				c.getPA().object(3541, 9677, 6748, -1, 0);
				c.getPA().object(3541, 9678, 6729, -3, 0);
			}
			break;
		case 6729:
			if(obX == 3545 && obY == 9677){
				c.getPA().object(3545, 9678, 6748, -3, 0);
				c.getPA().object(3545, 9677, 6729, -1, 0);
			} else if(obX == 3541 && obY == 9678) {
				c.getPA().object(3541, 9677, 6748, -1, 0);
				c.getPA().object(3541, 9678, 6729, -3, 0);
			}
			break;
		case 6726:
			if(obX == 3534 && obY == 9684) {
				c.getPA().object(3534, 9684, 6726, -4, 0);
				c.getPA().object(3535, 9684, 6745, -2, 0);
			} else if(obX == 3535 && obY == 9688) {
				c.getPA().object(3535, 9688, 6726, -2, 0);
				c.getPA().object(3534, 9688, 6745, -4, 0);
			}
			break;
		case 6745:
			if(obX == 3535 && obY == 9684) {
				c.getPA().object(3534, 9684, 6726, -4, 0);
				c.getPA().object(3535, 9684, 6745, -2, 0);
			} else if(obX == 3534 && obY == 9688) {
				c.getPA().object(3535, 9688, 6726, -2, 0);
				c.getPA().object(3534, 9688, 6745, -4, 0);
			}
			break;
		case 6743:
			if(obX == 3545 && obY == 9695) {
				c.getPA().object(3545, 9694, 6724, -1, 0);
				c.getPA().object(3545, 9695, 6743, -3, 0);
			} else if(obX == 3541 && obY == 9694) {
				c.getPA().object(3541, 9694, 6724, -1, 0);
				c.getPA().object(3541, 9695, 6743, -3, 0);
			}
			break;
		case 6724:
			if(obX == 3545 && obY == 9694) {
				c.getPA().object(3545, 9694, 6724, -1, 0);
				c.getPA().object(3545, 9695, 6743, -3, 0);
			} else if(obX == 3541 && obY == 9695) {
				c.getPA().object(3541, 9694, 6724, -1, 0);
				c.getPA().object(3541, 9695, 6743, -3, 0);
			}
			break; 

		case 6707: // verac
			c.getPA().movePlayer(3556, 3298, 0);
			break;
			
		case 6823:
			if(server.game.minigames.barrows.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[0][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2030, c.getX(), c.getY()-1, -1, 0, 120, 25, 200, 200, true, true);
				c.barrowsNpcs[0][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;

		case 6706: // torag 
			c.getPA().movePlayer(3553, 3283, 0);
			break;
			
		case 6772:
			if(server.game.minigames.barrows.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[1][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2029, c.getX()+1, c.getY(), -1, 0, 120, 20, 200, 200, true, true);
				c.barrowsNpcs[1][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
			
		case 6705: // karil stairs
			c.getPA().movePlayer(3565, 3276, 0);
			break;
		case 6822:
			if(server.game.minigames.barrows.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[2][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2028, c.getX(), c.getY()-1, -1, 0, 90, 17, 200, 200, true, true);
				c.barrowsNpcs[2][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		case 6704: // guthan stairs
			c.getPA().movePlayer(3578, 3284, 0);
			break;
		case 6773:
			if(server.game.minigames.barrows.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[3][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2027, c.getX(), c.getY()-1, -1, 0, 120, 23, 200, 200, true, true);
				c.barrowsNpcs[3][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		case 6703: // dharok stairs
			c.getPA().movePlayer(3574, 3298, 0);
			break;
		case 6771:
			if(server.game.minigames.barrows.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[4][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2026, c.getX(), c.getY()-1, -1, 0, 120, 45, 250, 250, true, true);
				c.barrowsNpcs[4][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		case 6702: // ahrim stairs
			c.getPA().movePlayer(3565, 3290, 0);
			break;
		case 6821:
			if(server.game.minigames.barrows.Barrows.selectCoffin(c, objectType)) {
				return;
			}
			if(c.barrowsNpcs[5][1] == 0) {
				Server.npcHandler.spawnNpc(c, 2025, c.getX(), c.getY()-1, -1, 0, 90, 19, 200, 200, true, true);
				c.barrowsNpcs[5][1] = 1;
			} else {
				c.sendMessage("You have already searched in this sarcophagus.");
			}
			break;
			
		
		
		case 8143:
			if (c.farm[0] > 0 && c.farm[1] > 0) {
				c.getFarming().pickHerb();
			}
		break;
	
			// DOORS
		case 1516:
		case 1519:
			if (c.objectY == 9698) {
				if (c.absY >= c.objectY)
					c.getPA().walkTo(0,-1);
				else
					c.getPA().walkTo(0,1);
				break;
			}
		case 1530:
		case 1531:
		case 1533:
		case 1534:
		case 11712:
		case 11711:
		case 11707:
		case 11708:
		case 6725:
		case 3198:
		case 3197:
			Server.objectHandler.doorHandling(objectType, c.objectX, c.objectY, 0);	
			break;
		
		case 9319:
			if (c.heightLevel == 0)
				c.getPA().movePlayer(c.absX, c.absY, 1);
			else if (c.heightLevel == 1)
				c.getPA().movePlayer(c.absX, c.absY, 2);
		break;
		
		case 9320:
			if (c.heightLevel == 1)
				c.getPA().movePlayer(c.absX, c.absY, 0);
			else if (c.heightLevel == 2)
				c.getPA().movePlayer(c.absX, c.absY, 1);
		break;
		
		case 4496:
		case 4494:
			if (c.heightLevel == 2) {
				c.getPA().movePlayer(c.absX - 5, c.absY, 1);
			} else if (c.heightLevel == 1) {
				c.getPA().movePlayer(c.absX + 5, c.absY, 0);
			}
		break;
		
		case 4493:
			if (c.heightLevel == 0) {
				c.getPA().movePlayer(c.absX - 5, c.absY, 1);
			} else if (c.heightLevel == 1) {
				c.getPA().movePlayer(c.absX + 5, c.absY, 2);
			}
		break;
		
		case 4495:
			if (c.heightLevel == 1) {
				c.getPA().movePlayer(c.absX + 5, c.absY, 2);
			}
		break;
		
		case 5126:
			if (c.absY == 3554)
				c.getPA().walkTo(0,1);
			else
				c.getPA().walkTo(0,-1);
		break;
		
		case 1759:
			if (c.objectX == 2884 && c.objectY == 3397) {
				c.getPA().movePlayer(c.absX, c.absY + 6400, 0);
			} else if (c.objectX == 2845 && c.objectY == 3516) {
				c.getPA().movePlayer(2884, 9798, 0);
			} else if (c.objectX == 2848 && c.objectY == 3513) {
				c.getPA().movePlayer(2884, 9798, 0);
			} else if (c.objectX == 2848 && c.objectY == 3519) {
				c.getPA().movePlayer(2884, 9798, 0);
			}
		break;
		case 1558:
			if (c.absX == 3041 && c.absY == 10308) {
                            c.getPA().movePlayer(3040, 10308, 0);	
                        } else if(c.absX == 3040 && c.absY == 10308) {
                                  c.getPA().movePlayer(3041, 10308, 0);
                        } else if(c.absX == 3040 && c.absY == 10307) {
                                  c.getPA().movePlayer(3041, 10307, 0);
                        } else if(c.absX == 3041 && c.absY == 10307) {
                                  c.getPA().movePlayer(3040, 10307, 0);
                        } else if(c.absX == 3044 && c.absY == 10341) {
                                  c.getPA().movePlayer(3045, 10341, 0);
                        } else if(c.absX == 3045 && c.absY == 10341) {
                                  c.getPA().movePlayer(3044, 10341, 0);
                        } else if(c.absX == 3044 && c.absY == 10342) {
                                  c.getPA().movePlayer(3045, 10342, 0);
                        } else if(c.absX == 3045 && c.absY == 10342) {
                                  c.getPA().movePlayer(3044, 10343, 0);
                        }
		break;
		case 1557:
			if (c.absX == 3023 && c.absY == 10312) {
                            c.getPA().movePlayer(3022, 10312, 0);	
                        } else if(c.absX == 3022 && c.absY == 10312) {
                                  c.getPA().movePlayer(3023, 10312, 0);
                        } else if(c.absX == 3023 && c.absY == 10311) {
                                  c.getPA().movePlayer(3022, 10311, 0);
                        } else if(c.absX == 3022 && c.absY == 10311) {
                                  c.getPA().movePlayer(3023, 10311, 0);
                        }
		break;
 		case 3203: //dueling forfeit
			if (c.duelCount > 0) {
				c.sendMessage("You may not forfeit yet.");
				break;
			}
			Client o = (Client) Server.playerHandler.players[c.duelingWith];				
			if(o == null) {
				c.getTradeAndDuel().resetDuel();
				c.getPA().movePlayer(Config.DUELING_RESPAWN_X+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
				break;
			}
			if(c.duelRule[0]) {
				c.sendMessage("Forfeiting the duel has been disabled!");
				break;
			}
			{
				o.getPA().movePlayer(Config.DUELING_RESPAWN_X+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
				c.getPA().movePlayer(Config.DUELING_RESPAWN_X+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), Config.DUELING_RESPAWN_Y+(Misc.random(Config.RANDOM_DUELING_RESPAWN)), 0);
				o.duelStatus = 6;
				o.getTradeAndDuel().duelVictory();
				c.getTradeAndDuel().resetDuel();
				c.getTradeAndDuel().resetDuelItems();
				o.sendMessage("The other player has forfeited the duel!");
				c.sendMessage("You forfeit the duel!");
				break;
			}
			
		case 409:
			if(c.playerLevel[5] < c.getPA().getLevelForXP(c.playerXP[5])) {
				c.startAnimation(645);
				c.playerLevel[5] = c.getPA().getLevelForXP(c.playerXP[5]);
				c.sendMessage("You recharge your prayer points.");
				c.getPA().refreshSkill(5);
			} else {
				c.sendMessage("You already have full prayer points.");
			}
			break;
		case 2873:
			if (!c.getItems().ownsCape()) {
				c.startAnimation(645);
				c.sendMessage("Saradomin blesses you with a cape.");
				c.getItems().addItem(2412, 1);
			}	
		break;
		case 2875:
			if (!c.getItems().ownsCape()) {
				c.startAnimation(645);
				c.sendMessage("Guthix blesses you with a cape.");
				c.getItems().addItem(2413, 1);
			}
		break;
		case 2874:
			if (!c.getItems().ownsCape()) {
				c.startAnimation(645);
				c.sendMessage("Zamorak blesses you with a cape.");
				c.getItems().addItem(2414, 1);
			}
		break;
		
		default:
			ScriptManager.callFunc("objectClick1_"+objectType, c, objectType, obX, obY);
			break;

		}
	}
	
	public void secondClickObject(int objectType, int obX, int obY) {
		c.clickObjectType = 0;
		switch(objectType) {
		case 1739: 
			//c.startAnimation(828);
			c.getPA().movePlayer(c.absX, c.absY, 0);
        break;
		case 1748: 
			c.startAnimation(828);
			c.getPA().movePlayer(c.absX, c.absY, 0);
        break;
		case 2561:
			c.getThieving().stealFromStall(2561,50,5);
		break;
		case 2565:
			c.getThieving().stealFromStall(2565,50,50);
		break;
		case 2560:
			c.getThieving().stealFromStall(2560,50,20);
		break;
		case 2562:
			c.getThieving().stealFromStall(2562,50,75);
		break;
		case 2563:
			c.getThieving().stealFromStall(2563,50,35);
		break;
		case 2564:
			c.getThieving().stealFromStall(2564,50,65);
		break;
		
		case 2646:
			if(System.currentTimeMillis() - c.buryDelay > 1500) {	
			c.getItems().addItem(1779,1);
			c.turnPlayerTo(c.objectX, c.objectY);	
			c.startAnimation(2292);
			c.getPA().object(-1, 2739, 3444, 0, 10);	
			c.sendMessage("You pick some flax.");
				c.buryDelay = System.currentTimeMillis();
				
			
			}	
			break;
		case 11666:
		case 3044:
		case 2781:
			System.out.println("al karhid furnace, HAI");
			c.getSmithing().sendSmelting();
		break;
		case 2090:
		case 2091:
		case 3042:
			Mining.prospectRock(c, "copper ore");
			break;
		case 2094:
		case 2095:
		case 3043:
			Mining.prospectRock(c, "tin ore");
			break;
		case 2110:
			Mining.prospectRock(c, "blurite ore");
			break;
		case 2092:
		case 2093:
			Mining.prospectRock(c, "iron ore");
			break;
		case 2100:
		case 2101:
			Mining.prospectRock(c, "silver ore");
			break;
		case 2098:
		case 2099:
			Mining.prospectRock(c, "gold ore");
			break;
		case 2096:
		case 2097:
			Mining.prospectRock(c, "coal");
			break;
		case 2102:
		case 2103:
			Mining.prospectRock(c, "mithril ore");
			break;
		case 2104:
		case 2105:
			Mining.prospectRock(c, "adamantite ore");
			break;
		case 2106:
		case 2107:
			Mining.prospectRock(c, "runite ore");
			break;
		case 450:
		case 451:
			Mining.prospectNothing(c);
		break;
			case 2213:
				c.getPA().openUpBank();
				break;
			case 11758:  //fally bank function
				c.getPA().openUpBank();
			break;
			case 2558:
				if (System.currentTimeMillis() - c.lastLockPick < 3000 || c.freezeTimer > 0)
					break;
				if (c.getItems().playerHasItem(1523,1)) {
						c.lastLockPick = System.currentTimeMillis();
						if (Misc.random(10) <= 3){
							c.sendMessage("You fail to pick the lock.");
							break;
						}
					if (c.objectX == 3044 && c.objectY == 3956) {
						if (c.absX == 3045) {
							c.getPA().walkTo2(-1,0);
						} else if (c.absX == 3044) {
							c.getPA().walkTo2(1,0);
						}
					
					} else if (c.objectX == 3038 && c.objectY == 3956) {
						if (c.absX == 3037) {
							c.getPA().walkTo2(1,0);
						} else if (c.absX == 3038) {
							c.getPA().walkTo2(-1,0);
						}				
					} else if (c.objectX == 3041 && c.objectY == 3959) {
						if (c.absY == 3960) {
							c.getPA().walkTo2(0,-1);
						} else if (c.absY == 3959) {
							c.getPA().walkTo2(0,1);
						}					
					}
				} else {
					c.sendMessage("I need a lockpick to pick this lock.");
				}
			break;
		default:
			ScriptManager.callFunc("objectClick2_"+objectType, c, objectType, obX, obY);
			break;
		}
	}
	
	
	public void thirdClickObject(int objectType, int obX, int obY) {
		c.clickObjectType = 0;
		c.sendMessage("Object type: " + objectType);
		switch(objectType) {
		//In here
		default:
			ScriptManager.callFunc("objectClick3_"+objectType, c, objectType, obX, obY);
			break;
		}
	}
	
	public void firstClickNpc(int npcType) {
		c.clickNpcType = 0;
		c.npcClickIndex = 0;
		c.fishitem = -1;
		if (c.fishitem != -1) {
            if (!c.getItems().playerHasItem(c.fishitem)) {
                c.sendMessage("You need a " + c.getItems().getItemName(c.fishitem) + " to fish for " + c.getItems().getItemName(c.fishies));
                c.fishing = false;
                return;
            }
            if (c.getItems().freeSlots() == 0) {
                c.sendMessage("Your inventory is full.");
                c.fishing = false;
                return;
            }
            if (c.playerFishing < c.fishreqt) {
                c.sendMessage("You need a fishing level of " + c.fishreqt + " to fish here.");
                c.fishing = false;
                return;
            }
            c.fishtimer = c.getFishing().fishtime(c.fishies, c.fishreqt);
        }
		switch(npcType) {
		case 519:  //bob's axes
			c.getShops().openShop(29);
		break;
		case 520:   // dirty custom shops
			c.sendMessage("npc 520 clicked");
			if((((c.absX+5) >=3014)&&((c.absX-5) <=3014))&&(((c.absY+5) >=3224)&&((c.absY-5) <=3224))) {     //gerrant fishing shop
					//c.sendMessage("opening custom shop 23");
					c.getShops().openShop(23);
					break;}
			if((((c.absX+5) >=3012)&&((c.absX-5) <=3012))&&(((c.absY+5) >=3258)&&((c.absY-5) <=3258))) {      //bettys magic emporium
					//c.sendMessage("opening custom shop 24");
					c.getShops().openShop(24);
					break;}
			if((((c.absX+5) >=3013)&&((c.absX-5) <=3013))&&(((c.absY+5) >=3246)&&((c.absY-5) <=3246))) {      //grums gold 
					//c.sendMessage("opening custom shop 25");
					c.getShops().openShop(25);
					break;}
			if((((c.absX+5) >=3026)&&((c.absX-5) <=3026))&&(((c.absY+5) >=3247)&&((c.absY-5) <=3247))) {      //brians battleaxe bazaar
					//c.sendMessage("opening custom shop 26");
					c.getShops().openShop(26);
					break;}
			if((((c.absX+5) >=3014)&&((c.absX-5) <=3014))&&(((c.absY+5) >=3204)&&((c.absY-5) <=3204))) {      //wydins food store
					//c.sendMessage("opening custom shop 27");
					c.getShops().openShop(27);
					break;}
			if((((c.absX+5) >=3045)&&((c.absX-5) <=3045))&&(((c.absY+5) >=3257)&&((c.absY-5) <=3257))) {      //port sarim bar
					//c.sendMessage("opening custom shop 28");
					c.getShops().openShop(28);
					break;}
			if((((c.absX+5) >=3288)&&((c.absX-5) <=3288))&&(((c.absY+5) >=3189)&&((c.absY-5) <=3189))) {      //zeke's superior scimitars
					//c.sendMessage("opening custom shop 30");
					c.getShops().openShop(30);
					break;}
			if((((c.absX+3) >=3316)&&((c.absX-3) <=3316))&&(((c.absY+3) >=3175)&&((c.absY-3) <=3175))) {      //Louie's Legs
					//c.sendMessage("opening custom shop 31");
					c.getShops().openShop(31);
					break;}
			if((((c.absX+5) >=3315)&&((c.absX-5) <=3315))&&(((c.absY+5) >=3161)&&((c.absY-5) <=3161))) {      //Ranael's Super Skirt Store
					//c.sendMessage("opening custom shop 32");
					c.getShops().openShop(32);
					break;}
			if((((c.absX+5) >=3287)&&((c.absX-5) <=3287))&&(((c.absY+5) >=3213)&&((c.absY-5) <=3213))) {      //Gem Trader
					//c.sendMessage("opening custom shop 33");
					c.getShops().openShop(33);
					break;}
			c.getShops().openShop(1);
			break;
		case 484:
			c.getDH().sendDialogues(88, 484);
			break;
		/*Quests*/
		case 278:
			if(c.cooksA == 0) {
				c.getDH().sendDialogues(100, npcType);
			} else if(c.cooksA == 1) {
				c.getDH().sendDialogues(108, npcType);
			} else if(c.cooksA == 2) {
				c.getDH().sendDialogues(110, npcType);
			} else if(c.cooksA == 3) {
				c.getDH().sendDialogues(112, npcType);
			}
		break;
		case 209:
			c.getDH().sendDialogues(86, 209);
			break;
		case 1917:
			c.getDH().sendDialogues(84, 1917);
			break;
		case 2201:
			c.getDH().sendDialogues(83, 2201);
			break;
		case 462:
			c.getDH().sendDialogues(17, 462);
			break;
		case 1696:
			c.getDH().sendDialogues(81, 1696);
			break;
		case 559:
			c.getDH().sendDialogues(999, 559);
			break;
		case 291:
			c.getDH().sendDialogues(77, 291);
			break;
		case 545:
			c.getDH().sendDialogues(999, 545);
			break;
		case 1658:
			c.getDH().sendDialogues(999, 1658);
			break;
		case 316:
            c.fishing = true;
            c.fishXP = 10 * Config.FISHING_EXPERIENCE;
            c.fishies = 317;
            c.fishreqt = 0;
            c.fishitem = 303;
            c.fishemote = 621;
            c.fishies2 = 321;
            c.fishreq2 = 15;
        break;
        case 334:
            c.fishing = true;
            c.fishXP = 317 * Config.FISHING_EXPERIENCE; // manta
            c.fishies = 389;
            c.fishreqt = 81;
            c.fishitem = 303;
            c.fishemote = 621;
        break;
        case 324://cage-harpoon spot choice cage
            c.fishing = true;
            c.fishXP = 90 * Config.FISHING_EXPERIENCE;
            c.fishies = 377;
            c.fishreqt = 40;
            c.fishitem = 301;
            c.fishemote = 619;
           //c.fishies2 = 389;
           //c.fishreq2 = 81;
        break;
        case 326:
            c.fishing = true;
            c.fishitem = 303;
            c.fishemote = 621;
            c.fishies = 363;
           	c.fishreqt = 46;
           	c.fishXP = 120 * Config.FISHING_EXPERIENCE;
            //c.fishies2 = 7944;
            //c.fishreq2 = 62;
            break;
        case 313:
            c.fishing = true;
            c.fishXP = 45 * Config.FISHING_EXPERIENCE;
            c.fishies = 341;
            c.fishreqt = 23;
            c.fishitem = 303;
            c.fishemote = 621;
            //c.fishies2 = 363;
            //c.fishreq2 = 46;
        break;
        case 309:   //adds flyfishing
            c.fishing = true;
            c.fishXP = 45 * Config.FISHING_EXPERIENCE;
            c.fishies = 335;   //
            c.fishreqt = 20;
			c.fishitem = 309;
            c.fishemote = 622;  //fly rod
            //c.fishemote = 619;
            c.fishies2 = 331;
            c.fishreq2 = 30;
        break;
        case 327:
        	c.fishing = true;
            c.fishXP = 45 * Config.FISHING_EXPERIENCE;
            c.fishies = 7944;
            c.fishreqt = 62;
            c.fishitem = 303;
            c.fishemote = 621;
            break;
		case 455:
			c.getDH().sendDialogues(73, 455);
			break;
		case 692:
			c.getDH().sendDialogues(75, 692);
			break;
		case 706:
			c.getDH().sendDialogues(70, 706);
			break;
		case 308:
			c.getDH().sendDialogues(66, 308);
			break;
		case 599:
			c.getDH().sendDialogues(63, 599);
			break;
		case 802:
			c.getDH().sendDialogues(60, 802);
			break;
		case 1304:
			c.getDH().sendDialogues(58, 1304);
			break;
		case 201:
			c.getDH().sendDialogues(9001, 201);
			break;
		case 494:
		case 495:
		case 496:
		case 497:
			c.getDH().sendDialogues(1000, 494);
		break;
			case 1598:
				if (c.slayerTask <= 0) {
					c.getDH().sendDialogues(11,npcType);
				} else {
					c.getDH().sendDialogues(13,npcType);
				}
			break;

			case 1526:
			c.getDH().sendDialogues(55,npcType);
			break;


			//case 212:
			case 589:
			c.getDH().sendDialogues(56,npcType);
			break;

			case 1152:
				c.getDH().sendDialogues(16,npcType);
			break;

			case 905:
				c.getDH().sendDialogues(5, npcType);
			break;
			case 460:
				c.getDH().sendDialogues(3, npcType);
			break;

			case 904:
				c.sendMessage("You have " + c.magePoints + " points.");
			break;
			
			case 521: case 550: case 595: case 561: case 531:
			c.getDH().sendDialogues(999, npcType);
			break;
			
			case 812:
			c.getDH().sendDialogues(998, npcType);
			break;
			
			case 546:
				c.getDH().sendDialogues(1004, npcType);
			break;
			case 548:
				c.getDH().sendDialogues(1008, npcType);
				break;
			case 641:
				c.getDH().sendDialogues(997, npcType);
			break;
			case 530:
				c.getDH().sendDialogues(996, npcType);
			break;
		default:
		//c.getDH().sendDialogues(144, npcType);
			c.getDH().sendDialogues(2000, npcType);
			ScriptManager.callFunc("npcClick1_"+npcType, c, npcType);
			if(c.playerRights == 3) 
				Misc.println("First Click Npc : "+npcType);
			break;
		}
	}

	public void secondClickNpc(int npcType) {
		c.fishitem = -1;
		c.clickNpcType = 0;
		c.npcClickIndex = 0;
		if (c.fishitem != -1) {
                    if (!c.getItems().playerHasItem(c.fishitem)) {
                        c.sendMessage("You need a " + c.getItems().getItemName(c.fishitem) + " to fish for " + c.getItems().getItemName(c.fishies));
                        c.fishing = false;
                        return;
                    }
                    if (c.getItems().freeSlots() == 0) {
                       c. sendMessage("Your inventory is full.");
                        c.fishing = false;
                        return;
                    }
                    if (c.playerFishing < c.fishreqt) {
                        c.sendMessage("You need a fishing level of " + c.fishreqt + " to fish here.");
                        c.fishing = false;
                        return;
                    }
                    c.fishtimer = c.getFishing().fishtime(c.fishies, c.fishreqt);
                }
		switch(npcType) {
		case 519:  //bob's axes
			c.getShops().openShop(29);
		break;
		case 520:   // dirty custom shops
			c.sendMessage("npc 520 clicked");
			if((((c.absX+5) >=3014)&&((c.absX-5) <=3014))&&(((c.absY+5) >=3224)&&((c.absY-5) <=3224))) {     //gerrant fishing shop
					//c.sendMessage("opening custom shop 23");
					c.getShops().openShop(23);
					break;}
			if((((c.absX+5) >=3012)&&((c.absX-5) <=3012))&&(((c.absY+5) >=3258)&&((c.absY-5) <=3258))) {      //bettys magic emporium
					//c.sendMessage("opening custom shop 24");
					c.getShops().openShop(24);
					break;}
			if((((c.absX+5) >=3013)&&((c.absX-5) <=3013))&&(((c.absY+5) >=3246)&&((c.absY-5) <=3246))) {      //grums gold 
					//c.sendMessage("opening custom shop 25");
					c.getShops().openShop(25);
					break;}
			if((((c.absX+5) >=3026)&&((c.absX-5) <=3026))&&(((c.absY+5) >=3247)&&((c.absY-5) <=3247))) {      //brians battleaxe bazaar
					//c.sendMessage("opening custom shop 26");
					c.getShops().openShop(26);
					break;}
			if((((c.absX+5) >=3014)&&((c.absX-5) <=3014))&&(((c.absY+5) >=3204)&&((c.absY-5) <=3204))) {      //wydins food store
					//c.sendMessage("opening custom shop 27");
					c.getShops().openShop(27);
					break;}
			if((((c.absX+5) >=3045)&&((c.absX-5) <=3045))&&(((c.absY+5) >=3257)&&((c.absY-5) <=3257))) {      //port sarim bar
					//c.sendMessage("opening custom shop 28");
					c.getShops().openShop(28);
					break;}
			if((((c.absX+5) >=3288)&&((c.absX-5) <=3288))&&(((c.absY+5) >=3189)&&((c.absY-5) <=3189))) {      //zeke's superior scimitars
					//c.sendMessage("opening custom shop 30");
					c.getShops().openShop(30);
					break;}
			if((((c.absX+3) >=3316)&&((c.absX-3) <=3316))&&(((c.absY+3) >=3175)&&((c.absY-3) <=3175))) {      //Louie's Legs
					//c.sendMessage("opening custom shop 31");
					c.getShops().openShop(31);
					break;}
			if((((c.absX+5) >=3315)&&((c.absX-5) <=3315))&&(((c.absY+5) >=3161)&&((c.absY-5) <=3161))) {      //Ranael's Super Skirt Store
					//c.sendMessage("opening custom shop 32");
					c.getShops().openShop(32);
					break;}
			if((((c.absX+5) >=3287)&&((c.absX-5) <=3287))&&(((c.absY+5) >=3213)&&((c.absY-5) <=3213))) {      //Gem Trader
					//c.sendMessage("opening custom shop 32");
					c.getShops().openShop(32);
					break;}
			c.getShops().openShop(1);
			break;
		case 209:
			c.getShops().openShop(22);
			break;
		case 1917:
			c.getShops().openShop(21);
			break;
		case 2620:
			c.getShops().openShop(20);
			break;
		case 2622:
			c.getShops().openShop(19);
			break;
		case 559:
			c.getShops().openShop(16);
			break;
		case 545:
			c.getShops().openShop(13);
			break;
		case 1658:
			c.getShops().openShop(14);
			break;
		case 333:
            c.fishing = true;
            c.fishXP = 100 * Config.FISHING_EXPERIENCE;
            c.fishies = 359;
            c.fishreqt = 35;
            c.fishitem = 311;
            c.fishemote = 618;
            //c.fishies2 = 371;
            //c.fishreq2 = 50;
			break;
	
        case 312:
            c.fishing = true;
            c.fishXP = 100  * Config.FISHING_EXPERIENCE;
            c.fishies = 359;
            c.fishreqt = 35;
            c.fishitem = 311;
            c.fishemote = 618;
            //c.fishies2 = 371;
           // c.fishreq2 = 50;
			break;
        case 324:
            c.fishing = true;
            c.fishXP = 100  * Config.FISHING_EXPERIENCE;
            c.fishies = 359;
            c.fishreqt = 35;
            c.fishitem = 311;
            c.fishemote = 618;
            //c.fishies2 = 371;
           // c.fishreq2 = 50;
            break;
        case 334:
            c.fishing = true;
            c.fishXP = 110 * Config.FISHING_EXPERIENCE;
            c.fishies = 383;
            c.fishreqt = 76;
            c.fishitem = 311;
            c.fishemote = 618;
            break;
        case 316:
            c.fishing = true;
            c.fishXP = 30 * Config.FISHING_EXPERIENCE;
			c.fishies = 327;
			c.fishreqt = 5;
            c.fishitem = 307;
            c.fishemote = 622;
            //c.fishies2 = 345;
           // c.fishreq2 = 10;
			break;
        case 326:
            c.fishing = true;
            c.fishXP = 30 * Config.FISHING_EXPERIENCE;
			c.fishies = 327;
			c.fishreqt = 5;
            c.fishitem = 307;
            c.fishemote = 622;
            //c.fishies2 = 345;
            //c.fishreq2 = 10;
			break;
       case 331:
            c.fishing = true;
            c.fishXP = 60 * Config.FISHING_EXPERIENCE;
            c.fishies = 349;
            c.fishreqt = 25;
            c.fishitem = 307;
            c.fishemote = 622;
			break;
       case 313:
            c.fishing = true;
            c.fishXP = 110 * Config.FISHING_EXPERIENCE;
            c.fishies = 383;
            c.fishreqt = 76;
            c.fishitem = 311;
            c.fishemote = 618;
        break;
		case 692:
			c.getShops().openShop(11);
			break;
			/* Thieving */
			//case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 9:
			case 18:
			case 20:
			case 26:
			case 21:
				c.getThieving().stealFromNPC(npcType);
			break;
			/* - - Shops - - */
			/* General Store / Assistant Varrock */
			case 521:
			c.getShops().openShop(1);
			break;
			/* Thessalia Varrock */
			case 548:
			c.getShops().openShop(2);
			break;
			/* Zaff Varrock */
			case 546:
			c.getShops().openShop(3);
			break;
			/* Swordshop Varrock */
			case 561:
			c.getShops().openShop(4);
			break;
			/* Tea Shop */
			case 595:
			c.getShops().openShop(5);
			break;
			/* Aubury's Rune Store */
			case 553:
			c.getShops().openShop(6);
			break;
			/* Lowe's Archery Emporium */
			case 550:
			c.getShops().openShop(7);
			break;
			/* Horvik's Armour Shop */
			case 549:
			c.getShops().openShop(8);
			break;
			case 3788:
			//c.getShops().openVoid();
			break;
			case 494: 
			case 495: 
				case 496: 
					case 497: 
						case 498: 
							case 499:
			c.getPA().openUpBank();
			break;
			default:
			//c.getDH().sendDialogues(144, npcType);
				ScriptManager.callFunc("npcClick2_"+npcType, c, npcType);
				if(c.playerRights == 3) 
					Misc.println("Second Click Npc : "+npcType);
				break;
			
		}
	}
	
	public void thirdClickNpc(int npcType) {
		c.clickNpcType = 0;
		c.npcClickIndex = 0;
		switch(npcType) {
			case 553:
			c.getPA().startTeleport2(2898, 4819, 0);
			break;
			default:
			//c.getDH().sendDialogues(144, npcType);
				ScriptManager.callFunc("npcClick3_"+npcType, c, npcType);
				if(c.playerRights == 3) 
					Misc.println("Third Click NPC : "+npcType);
				break;

		}
	}
	

}