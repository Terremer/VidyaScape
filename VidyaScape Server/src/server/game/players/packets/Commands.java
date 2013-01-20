package server.game.players.packets;

import server.Config;
import server.Connection;
import server.Server;
import server.game.players.Client;
import server.game.players.Player;
import server.game.players.PacketType;
import server.game.players.PlayerHandler;
import core.util.Misc;

public class Commands implements PacketType {
public boolean resetAnim = false;
	@Override
    public void processPacket(Client c, int packetType, int packetSize) {
        String playerCommand = c.getInStream().readString();
        if (Config.SERVER_DEBUG) {
            Misc.println(c.playerName + " playerCommand: " + playerCommand);
        }
		{
		if (playerCommand.startsWith("patchnotes")) {
				for(int i = 8144; i < 8195; i++) {
					c.getPA().sendFrame126("", i);
				}		
				c.getPA().sendFrame126("@dre@Server Patch Notes", 8144);
				c.getPA().sendFrame126("", 8145);
				c.getPA().sendFrame126("-= January 19 =-", 8147);
				c.getPA().sendFrame126("-Amulets of Glory now work", 8148);
				c.getPA().sendFrame126("-More ladder cases fixed (standard)", 8149);
				c.getPA().sendFrame126("-The Heroes Guild cave is now accessible", 8150);
				c.getPA().sendFrame126("-= January 10 =-", 8151);
				c.getPA().sendFrame126("-all teles now use magic staves correctly", 8152);
				c.getPA().sendFrame126("-teles now give xp (and at 1.5x rate)", 8153);
				c.getPA().sendFrame126("-another ladder patch (IT NEVER ENDS)", 8154);
				c.getPA().sendFrame126("-Trollheim and Watchtower teles work now", 8155);
				c.getPA().sendFrame126("-added ::planned", 8156);
				c.getPA().sendFrame126("-= January 08 =-", 8157);
				c.getPA().sendFrame126("-another door&ladder patch, more should work now :)", 8158);
				c.getPA().sendFrame126("-added a safe server shutdown, with global warnings", 8159);
				c.getPA().sendFrame126("-::mypos command is public, use it for bug reporting pls", 8160);
				c.getPA().sendFrame126("-Varrock tele now uses magic staves correctly, more ", 8161);
				c.getPA().sendFrame126("coming soon, and xp", 8162);
				c.getPA().sendFrame126("-= January 07 =-", 8163);
				c.getPA().sendFrame126("-al kharid now has shops/bob's shop works", 8164);
				c.getPA().sendFrame126("-::patchnotes got an overhaul!", 8161);
				c.getPA().sendFrame126("-al kharid furnace now turned(doesn't work still)", 8165);
				c.getPA().sendFrame126("-fally banks now work", 8166);
				c.getPA().sendFrame126("-::y *actually* works as intended to", 8167);
				c.getPA().sendFrame126("-ladders and stairs in port sarim have been fixed", 8168);
				c.getPA().sendFrame126("-all of port sarim now has the appropriate shops", 8169);
				c.getPA().sendFrame126("-a rudimentry custom shop system has been coded", 8170);
				c.getPA().sendFrame126("-anchovies can be fished", 8171);
				c.getPA().sendFrame126("-salmon can be fished (they also don't use feathers up)", 8172);
				c.getPA().sendFrame126("-::y now works as intended JK IT WAS STILL BROKE", 8173);
				c.getPA().sendFrame126("-added ::help and ::commands and ::y", 8174);
				c.getPA().sendFrame126("-lure spots aren't npcs (fly fishing doesn't use feathers)", 8175);
				c.getPA().sendFrame126("-fishing now uses bait when catching sardines", 8176);
				c.getPA().sendFrame126("-farmers can drop spades", 8177);
				c.getPA().sendFrame126("-goblins can now drop the 4 elemental tallys", 8178);
				c.getPA().sendFrame126("-air,water,fire and earth altars now work (fuck tiaras)", 8179);
				c.getPA().sendFrame126("-bamboo ladders work now", 8180);
				c.getPA().sendFrame126("-anchovies can be eaten", 8181);
				
				c.getPA().showInterface(8134);

				}
		if (playerCommand.startsWith("planned")) {
				for(int i = 8144; i < 8195; i++) {
					c.getPA().sendFrame126("", i);
				}		
				c.getPA().sendFrame126("@dre@Server Planned Updates and broke shit", 8144);
				c.getPA().sendFrame126("", 8145);
				c.getPA().sendFrame126("-=IN THE FUTURE/Shit that's broke=-", 8147);
				c.getPA().sendFrame126("-I want to add Buy X, but this requires a client patch", 8148);
				c.getPA().sendFrame126("-Stalls need to actually have droptables, not just rings", 8149);
				c.getPA().sendFrame126("-Pure ess fails to work in a lot of cases", 8150);
				c.getPA().showInterface(8134);
				}					 
					
			if (playerCommand.equalsIgnoreCase("mypos")) {
                c.sendMessage("Your position is X: " + c.absX + " Y: " +c.absY);
        	}
		    if (playerCommand.startsWith("help")||playerCommand.startsWith("commands")) {
				
				try {
					c.sendMessage("usable commands are:");
					c.sendMessage("::home, ::telenorth, ::telesouth, ::teleeast, ::telewest, ::patchnotes, :planned");
					c.sendMessage("::players, ::changepass, ::timeplayed, ::yell (or ::y), ::mypos");
					} 
				catch(Exception e) {
					c.sendMessage("something broke");
				}
				}
				if (playerCommand.startsWith("home")) {
				if (c.inWild())
				return;
				try {
					c.teleportToX = 3222;
					c.teleportToY = 3218;
					c.heightLevel = 0;
					c.sendMessage("By channeling some of the power of Odel...");
					c.sendMessage("you have been teleported to Lummy");
							} 
						
					
				catch(Exception e) {
					c.sendMessage("Player is probably offline.");
				}
				}
			if (playerCommand.startsWith("telenorth")) {
				if (c.inWild())
				return;
				try {
					c.teleportToX = c.absX;
					c.teleportToY = c.absY+3;
					c.heightLevel = c.heightLevel;
							} 
						
					
				catch(Exception e) {
					c.sendMessage("Player is probably offline.");
				}
				}
				if (playerCommand.startsWith("telesouth")) {
				if (c.inWild())
				return;
				try {
					c.teleportToX = c.absX;
					c.teleportToY = c.absY-3;
					c.heightLevel = c.heightLevel;
							} 
						
					
				catch(Exception e) {
					c.sendMessage("Player is probably offline.");
				}
				}
				if (playerCommand.startsWith("teleeast")) {
				if (c.inWild())
				return;
				try {
					c.teleportToX = c.absX+3;
					c.teleportToY = c.absY;
					c.heightLevel = c.heightLevel;
							} 
						
					
				catch(Exception e) {
					c.sendMessage("Player is probably offline.");
				}
				}
				if (playerCommand.startsWith("telewest")) {
				if (c.inWild())
				return;
				try {
					c.teleportToX = c.absX-3;
					c.teleportToY = c.absY;
					c.heightLevel = c.heightLevel;
							} 
						
					
				catch(Exception e) {
					c.sendMessage("Player is probably offline.");
				}
				}
        	if (playerCommand.equalsIgnoreCase("players")) {
                c.sendMessage("Current amount of players online: @red@" + PlayerHandler.getPlayerCount() + "@bla@.");
        	}
            if (playerCommand.startsWith("changepass") && playerCommand.length() > 15) {
                c.playerPass = playerCommand.substring(15);
                c.sendMessage("Your password is now: @red@" + c.playerPass);
            }
            if (playerCommand.equalsIgnoreCase("timeplayed")) {
            	c.sendMessage("Time played: @red@" + c.getPlaytime() + ".");
            }
            if (playerCommand.equalsIgnoreCase("test1")) {
            	c.getDH().sendDialogues(150, 1);
            }
            if ((playerCommand.startsWith("yell"))||(playerCommand.startsWith("y"))){
    				for (int j = 0; j < Server.playerHandler.players.length; j++) {
    					if (Server.playerHandler.players[j] != null) {
    						if (c.playerRights == 0) {
        						Client c2 = (Client)Server.playerHandler.players[j];
								if(playerCommand.startsWith("yell"))
								{c2.sendMessage("@dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(5)) +"");}
								else
								{c2.sendMessage("@dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(2)) +"");}
        					}
    						if (c.playerRights == 1) {
        						Client c2 = (Client)Server.playerHandler.players[j];
								if(playerCommand.startsWith("yell"))
								{c2.sendMessage("[MOD] @dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(5)) +"");}
								else
								{c2.sendMessage("[MOD] @dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(2)) +"");}
        					}
    						if (c.playerRights == 2) {
    							Client c2 = (Client)Server.playerHandler.players[j];
								if(playerCommand.startsWith("yell"))
								{c2.sendMessage("[ADMIN] @dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(5)) +"");}
								else
								{c2.sendMessage("[ADMIN] @dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(2)) +"");}
    						}
    						if (c.playerRights == 3) {
    							Client c2 = (Client)Server.playerHandler.players[j];
								if(playerCommand.startsWith("yell"))
								{c2.sendMessage("[ADMIN] @dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(5)) +"");}
								else
								{c2.sendMessage("[ADMIN] @dbl@" + Misc.capitalize(c.playerName) +": " + Misc.optimizeText(playerCommand.substring(2)) +"");}
    						}
    					}
    				}
            }
           if (playerCommand.startsWith("noclip") && (c.playerRights != 3)) {
    				return;			
    			}
            }
        if (c.playerRights >= 1) {
        	if (playerCommand.startsWith("mute")) {
            try {
                String playerToBan = playerCommand.substring(5);
                Connection.addNameToMuteList(playerToBan);
                for (int i = 0; i < Config.MAX_PLAYERS; i++) {
                    if (Server.playerHandler.players[i] != null) {
                        if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
                            Client c2 = (Client) Server.playerHandler.players[i];
                            c2.sendMessage("You have been muted by: " + Misc.capitalize(c.playerName) + ".");
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                c.sendMessage("Player is probably offline.");
            }
        }
        if (c.playerRights >= 2) {
        	if (playerCommand.startsWith("ipmute")) {
        		try {
        			String playerToBan = playerCommand.substring(7);
        			for (int i = 0; i < Config.MAX_PLAYERS; i++) {
        				if (Server.playerHandler.players[i] != null) {
                    	if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
                            Connection.addIpToMuteList(Server.playerHandler.players[i].connectedFrom);
                            c.sendMessage("You have IP Muted the user: " + Server.playerHandler.players[i].playerName);
                            Client c2 = (Client) Server.playerHandler.players[i];
                            c2.sendMessage("You have been muted by: " + Misc.capitalize(c.playerName));
                            break;
                        }
                    }
                }
        		} catch (Exception e) {
        			c.sendMessage("Player is probably offline.");
        		}
        		if (playerCommand.startsWith("unipban")) {
            		try {
            			String playerToBan = playerCommand.substring(9);
            			for (int i = 0; i < Config.MAX_PLAYERS; i++) {
            				if (Server.playerHandler.players[i] != null) {
            					if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
            						Connection.unIPBanUser(Server.playerHandler.players[i].connectedFrom);
            						c.sendMessage("You have un-IPbanned the user: " + Server.playerHandler.players[i].playerName);
                                break;
            					}
            				}
            			}
            		} catch (Exception e) {
            			c.sendMessage("Player is probably offline.");
            		}
            	}
        	if (playerCommand.startsWith("unipmute")) {
        		try {
        			String playerToBan = playerCommand.substring(9);
        			for (int i = 0; i < Config.MAX_PLAYERS; i++) {
        				if (Server.playerHandler.players[i] != null) {
        					if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
        						Connection.unIPMuteUser(Server.playerHandler.players[i].connectedFrom);
        						c.sendMessage("You have un IP-muted the user: " + Server.playerHandler.players[i].playerName);
                            break;
        					}
        				}
        			}
        		} catch (Exception e) {
        			c.sendMessage("Player is probably offline.");
        		}
        	}
        	if (playerCommand.startsWith("unmute")) {
        		try {
        			String playerToBan = playerCommand.substring(7);
        			Connection.unMuteUser(playerToBan);
        		} catch (Exception e) {
        			c.sendMessage("Player is probably offline.");
        		}
        	}
        	}
        }
        if (c.playerRights == 3) {
		    if (playerCommand.startsWith("shutdownserver")) {
				try {	
					for (int j = 0; j < Server.playerHandler.players.length; j++) {
    					if (Server.playerHandler.players[j] != null) {
    							Client c2 = (Client)Server.playerHandler.players[j];
								c2.sendMessage("[SYSTEM] @dbl@" + "The server is shutting down in 1 minute!");
							}
    					}
					Server.beginshutdownServer = true;
				} catch(Exception e) {
					c.sendMessage("Something broke :(");
				}
			}
        	if (playerCommand.startsWith("xteleto")) {
				String name = playerCommand.substring(8);
				for (int i = 0; i < Config.MAX_PLAYERS; i++) {
					if (Server.playerHandler.players[i] != null) {
						if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(name)) {
							c.getPA().movePlayer(Server.playerHandler.players[i].getX(), Server.playerHandler.players[i].getY(), Server.playerHandler.players[i].heightLevel);
						}
					}
				}			
			}
        	if (playerCommand.equals("test")) {
        		c.playerWalkIndex = 744;
        	}
        	if (playerCommand.equals("resetanim")) {
        		c.playerWalkIndex = 0x333;
        	}
        	if (playerCommand.startsWith("ban") && playerCommand.charAt(7) == ' ') { // use as ::ban name
				try {	
					String playerToBan = playerCommand.substring(8);
					Connection.addNameToBanList(playerToBan);
					Connection.addNameToFile(playerToBan);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Server.playerHandler.players[i].disconnected = true;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player is not online.");
				}
			}
        	if (playerCommand.startsWith("kick")) {
				try {	
					String playerToKick = playerCommand.substring(5);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToKick)) {
								Server.playerHandler.players[i].disconnected = true;
								Server.playerHandler.players[i].properLogout = true;
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player is not online.");
				}
			}
        	if (playerCommand.startsWith("teletome")) {
				if (c.inWild())
				return;
				try {	
					String playerToBan = playerCommand.substring(9);
					for(int i = 0; i < Config.MAX_PLAYERS; i++) {
						if(Server.playerHandler.players[i] != null) {
							if(Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
								Client c2 = (Client)Server.playerHandler.players[i];
								c2.teleportToX = c.absX;
								c2.teleportToY = c.absY;
								c2.heightLevel = c.heightLevel;
								c.sendMessage("You have teleported " + Misc.capitalize(c2.playerName) + " to you.");
								c2.sendMessage("You have been teleported to " + Misc.capitalize(c.playerName) + "");
							} 
						}
					}
				} catch(Exception e) {
					c.sendMessage("Player is probably offline.");
				}
			}
        	if (playerCommand.startsWith("item")) {
                try {
                    String[] args = playerCommand.split(" ");
                    if (args.length == 3) {
                        int newItemID = Integer.parseInt(args[1]);
                        int newItemAmount = Integer.parseInt(args[2]);
                        if ((newItemID <= 20000) && (newItemID >= 0)) {
                            c.getItems().addItem(newItemID, newItemAmount);
                            c.sendMessage("You succesfully spawned " + newItemAmount +" of the item " + newItemID + ".");
                            System.out.println("Spawned: " + newItemID + " by: " + Misc.capitalize(c.playerName));
                        } else {
                            c.sendMessage("Could not complete spawn request.");
                        }
                    } else {
                        c.sendMessage("Use as ::item 4151 1");
                    }
                } catch (Exception e) {
                }
        	}
        	if (playerCommand.startsWith("xteleto")) {
    				String name = playerCommand.substring(8);
    				for (int i = 0; i < Config.MAX_PLAYERS; i++) {
    					if (Server.playerHandler.players[i] != null) {
    						if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(name)) {
    							c.getPA().movePlayer(Server.playerHandler.players[i].getX(), Server.playerHandler.players[i].getY(), Server.playerHandler.players[i].heightLevel);
    						}
    					}
    				}	
        	}
        	if (playerCommand.startsWith("smsg")) {
        		String[] args = playerCommand.split(" ");
        		for (int j = 0; j < Server.playerHandler.players.length; j++) {
					if (Server.playerHandler.players[j] != null) {
						Client c2 = (Client)Server.playerHandler.players[j];
						c2.sendMessage("" + Misc.optimizeText(playerCommand.substring(5)));
					}
        		}
        	}
        	if (playerCommand.equalsIgnoreCase("random")) {
        		c.sendMessage("" + Misc.random(100));
        	}
        	if(playerCommand.startsWith("pnpc")) {
                	int npc = Integer.parseInt(playerCommand.substring(5));
                	if(npc < 9999){
                		c.npcId2 = npc;
                		c.isNpc = true;
                		c.updateRequired = true;
                		c.appearanceUpdateRequired = true;
                	}
        	}
        	if(playerCommand.startsWith("unpc")) {
                	c.isNpc = false;
                	c.updateRequired = true;
                	c.appearanceUpdateRequired = true;
        	}
        	if (playerCommand.startsWith("object")) {
    			String[] args = playerCommand.split(" ");				
    			c.getPA().object(Integer.parseInt(args[1]), c.absX, c.absY, 0, 10);
        	}
        	if (playerCommand.startsWith("empty")) {
            	c.getItems().removeAllItems();
            	c.sendMessage("You empty your inventory");
        	}
        	if (playerCommand.startsWith("tele")) {
				String[] arg = playerCommand.split(" ");
				if (arg.length > 3)
					c.getPA().movePlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),Integer.parseInt(arg[3]));
				else if (arg.length == 3)
					c.getPA().movePlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),c.heightLevel);
        	}
        	if (playerCommand.startsWith("switch")) {
                if (c.playerMagicBook == 0) {
                    c.playerMagicBook = 1;
                    c.setSidebarInterface(6, 12855);
                    c.sendMessage("An ancient wisdomin fills your mind.");
                    c.getPA().resetAutocast();
                } else {
                    c.setSidebarInterface(6, 1151);
                    c.playerMagicBook = 0;
                    c.sendMessage("You feel a drain on your memory.");
                    c.autocastId = -1;
                    c.getPA().resetAutocast();
                }
        	}
            if (playerCommand.startsWith("interface")) {
                try {
                    String[] args = playerCommand.split(" ");
                    int a = Integer.parseInt(args[1]);
                    c.getPA().showInterface(a);
                } catch (Exception e) {
                    c.sendMessage("::interface id");
                }
            }
            if (playerCommand.startsWith("npc")) {
                try {
                    int newNPC = Integer.parseInt(playerCommand.substring(4));
                    if (newNPC > 0) {
                        Server.npcHandler.spawnNpc(c, newNPC, c.absX, c.absY, 0, 0, 120, 7, 70, 70, false, false);
                    } else {
                        c.sendMessage("Requested NPC does not exist.");
                    }
                } catch (Exception e) {
                }
            }
            if (playerCommand.startsWith("ipban")) {
                try {
                    String playerToBan = playerCommand.substring(6);
                    for (int i = 0; i < Config.MAX_PLAYERS; i++) {
                        if (Server.playerHandler.players[i] != null) {
                            if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
                                Connection.addIpToBanList(Server.playerHandler.players[i].connectedFrom);
                                Connection.addIpToFile(Server.playerHandler.players[i].connectedFrom);
                                c.sendMessage("You have IP banned the user: " + Server.playerHandler.players[i].playerName + " with the host: " + Server.playerHandler.players[i].connectedFrom);
                                Server.playerHandler.players[i].disconnected = true;
                            }
                        }
                    }
                } catch (Exception e) {
                    c.sendMessage("Player is probably offline.");
                }
            }

            if (playerCommand.startsWith("openbank")) {
                 c.getPA().openUpBank();
            }
           if (playerCommand.startsWith("gfx")) {
                String[] args = playerCommand.split(" ");
                c.gfx0(Integer.parseInt(args[1]));
           }
           if (playerCommand.startsWith("update")) {
                String[] args = playerCommand.split(" ");
                int a = Integer.parseInt(args[1]);
                PlayerHandler.updateSeconds = a;
                PlayerHandler.updateAnnounced = false;
                PlayerHandler.updateRunning = true;
                PlayerHandler.updateStartTime = System.currentTimeMillis();
           }
           if (playerCommand.startsWith("ban") && playerCommand.charAt(3) == ' ') {
                try {
                    String playerToBan = playerCommand.substring(4);
                    Connection.addNameToBanList(playerToBan);
                    Connection.addNameToFile(playerToBan);
                    for (int i = 0; i < Config.MAX_PLAYERS; i++) {
                        if (Server.playerHandler.players[i] != null) {
                            if (Server.playerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
                                Server.playerHandler.players[i].disconnected = true;
                            }
                        }
                    }
                } catch (Exception e) {
                    c.sendMessage("Player is probably offline.");
                }
           }
           if (playerCommand.startsWith("unban")) {
                try {
                    String playerToBan = playerCommand.substring(6);
                    Connection.removeNameFromBanList(playerToBan);
                    c.sendMessage(playerToBan + " has been unbanned.");
                } catch (Exception e) {
                    c.sendMessage("Player is probably offline.");
                }
           }
           if (playerCommand.startsWith("anim")) {
                String[] args = playerCommand.split(" ");
                c.startAnimation(Integer.parseInt(args[1]));
                c.getPA().requestUpdates();
           }
           if (playerCommand.startsWith("setlevel")) {
                try {
                    String[] args = playerCommand.split(" ");
                    int skill = Integer.parseInt(args[1]);
                    int level = Integer.parseInt(args[2]);
                    if (level > 99) {
                        level = 99;
                    } else if (level < 0) {
                        level = 1;
                    }
                    c.playerXP[skill] = c.getPA().getXPForLevel(level) + 5;
                    c.playerLevel[skill] = c.getPA().getLevelForXP(c.playerXP[skill]);
                    c.getPA().refreshSkill(skill);
                } catch (Exception e) {
                }	
           }
        	}
        }
	}
}
