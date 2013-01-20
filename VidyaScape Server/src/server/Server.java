package server;

import java.io.IOException;


import server.world.WalkingCheck;
import java.net.InetSocketAddress;
import java.text.DecimalFormat;
import org.apache.mina.common.IoAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;
import server.event.CycleEventHandler;
import server.world.StillGraphicsManager;
import server.world.PlayerManager;
import server.event.EventManager;
import server.clip.region.ObjectDef;
import server.clip.region.Region;
import server.game.npcs.NPCHandler;
import server.game.players.HighscoresConfig;
import server.game.players.PlayerHandler;
import server.game.players.Player;
import server.game.players.Client;
import server.game.players.PlayerSave;
import server.game.objects.doors.Doors;
import server.game.objects.doors.DoubleDoors;
import server.game.minigames.*;
import server.game.minigames.castlewars.CastleWars;
import server.game.minigames.pestcontrol.PestControl;
import server.game.minigames.tzhaar.FightCaves;
import server.game.minigames.tzhaar.FightPits;
import core.net.ConnectionHandler;
import core.net.ConnectionThrottleFilter;
import core.util.SimpleTimer;
import core.util.log.Logger;
import server.world.ItemHandler;
import server.world.ObjectHandler;
import server.world.ObjectManager;
import server.world.ShopHandler;
import server.world.ClanChatHandler;

/**
 * Server.java
 *
 * @author Sanity
 * @author Graham
 * @author Blake
 * @author Ryan Lmctruck30
 * @author Izumi
 *
 */

public class Server {
	
	public static PlayerManager playerManager = null;
	private static StillGraphicsManager stillGraphicsManager = null;
	
	public static boolean sleeping;
	public static final int cycleRate;
	public static boolean UpdateServer = false;
	public static long lastMassSave = System.currentTimeMillis();
	private static IoAcceptor acceptor;
	private static ConnectionHandler connectionHandler;
	private static ConnectionThrottleFilter throttleFilter;
	private static SimpleTimer engineTimer, debugTimer;
	private static long cycleTime, cycles, totalCycleTime, sleepTime;
	private static DecimalFormat debugPercentFormat;
	public static boolean shutdownServer = false;	
	public static boolean shuttingdownServer = false;	 //added for safe shutdown command
	public static boolean beginshutdownServer = false;//added for safe shutdown command
	public static long shutdownstartedtime;//added for safe shutdown command
	public static boolean shutdownServer30sec = false;//added for safe shutdown command
	public static boolean shutdownServer5sec = false;//added for safe shutdown command
	public static boolean shutdownClientHandler;			
	public static int serverlistenerPort; 
	public static ItemHandler itemHandler = new ItemHandler();
	public static PlayerHandler playerHandler = new PlayerHandler();
    public static NPCHandler npcHandler = new NPCHandler();
	public static ShopHandler shopHandler = new ShopHandler();
	public static ObjectHandler objectHandler = new ObjectHandler();
	public static ObjectManager objectManager = new ObjectManager();
	public static CastleWars castleWars = new CastleWars();
	public static FightPits fightPits = new FightPits();
	public static PestControl pestControl = new PestControl();
	public static ClanChatHandler clanChat = new ClanChatHandler();
	public static FightCaves fightCaves = new FightCaves();
	
	static {
		if(!Config.SERVER_DEBUG) {
			serverlistenerPort = 43594;
		} else {
			serverlistenerPort = 43594;
		}
		cycleRate = 600;
		shutdownServer = false;
		engineTimer = new SimpleTimer();
		debugTimer = new SimpleTimer();
		sleepTime = 0;
		debugPercentFormat = new DecimalFormat("0.0#%");
	}
	
	public static void main(java.lang.String args[]) throws NullPointerException, IOException {
		/**
		 * Starting Up Server
		 */
		ObjectDef.loadConfig();
		Region.load();
		WalkingCheck.load();
		System.setOut(new Logger(System.out));
		System.setErr(new Logger(System.err));
		System.out.println("[Stage 1] NPC drops have been loaded...");
		System.out.println("[Stage 2] NPC spawns have been loaded...");
		System.out.println("[Stage 3] Shops have been loaded...");
		System.out.println("[Stage 4] Object spawns have been loaded...");
		System.out.println("[Stage 5] Connections are now being accepted...");
		
		/**
		 * Accepting Connections
		 */
		acceptor = new SocketAcceptor();
		connectionHandler = new ConnectionHandler();
		
		playerManager = PlayerManager.getSingleton();
		playerManager.setupRegionPlayers();
		stillGraphicsManager = new StillGraphicsManager();
		SocketAcceptorConfig sac = new SocketAcceptorConfig();
		sac.getSessionConfig().setTcpNoDelay(false);
		sac.setReuseAddress(true);
		sac.setBacklog(100);
		
		throttleFilter = new ConnectionThrottleFilter(Config.CONNECTION_DELAY);
		sac.getFilterChain().addFirst("throttleFilter", throttleFilter);
		acceptor.bind(new InetSocketAddress(serverlistenerPort), connectionHandler, sac);

		/**
		 * Initialise Handlers
		 */
		EventManager.initialize();
		Doors.getSingleton().load();
		DoubleDoors.getSingleton().load();
		Connection.initialize();
		HighscoresConfig.loadHighscores();
		
		/**
		 * Server Successfully Loaded 
		 */
		System.out.println("[Final Stage] VIDYAscape has been launched on localhost:" + serverlistenerPort + "...");
		/**
		 * Main Server Tick
		 */
		try {
			while (!Server.shutdownServer) {
				if (Server.beginshutdownServer == true)
				{
					System.out.println("Server shutdown has begun.");
					shutdownstartedtime = System.currentTimeMillis();
					System.out.println("Started at: " + shutdownstartedtime);
					beginshutdownServer = false;
					shuttingdownServer = true;
				}
				if (Server.shuttingdownServer == true)
				{
					if(((System.currentTimeMillis()-shutdownstartedtime) > 30 * 1000)&&shutdownServer30sec == false)
					{
					for (int j = 0; j < Server.playerHandler.players.length; j++) {
    					if (Server.playerHandler.players[j] != null) {
    							Client c2 = (Client)Server.playerHandler.players[j];
								c2.sendMessage("[SYSTEM] @dbl@" + "The server is shutting down in 30 seconds!");
							}
    					}
					shutdownServer30sec = true;
					}
					if(((System.currentTimeMillis()-shutdownstartedtime) > 55 * 1000)&&shutdownServer5sec == false)
					{
					for (int j = 0; j < Server.playerHandler.players.length; j++) {
    					if (Server.playerHandler.players[j] != null) {
    							Client c2 = (Client)Server.playerHandler.players[j];
								c2.sendMessage("[SYSTEM] @dbl@" + "The server is shutting down in 5 seconds!");
							}
    					}
					shutdownServer5sec = true;
					}
					if((System.currentTimeMillis()-shutdownstartedtime) > 60 * 1000)
					{
						System.out.println("The time is: " + System.currentTimeMillis());
						System.out.println("Server shutdown is happening NOW!.");
						for (int i = 0; i < Server.playerHandler.players.length; i++) {
							if (Server.playerHandler.players[i] != null) {
						System.out.println("Disconnecting player " + Server.playerHandler.players[i].playerName);
						Server.playerHandler.players[i].disconnected = true;
						Server.playerHandler.players[i].properLogout = true;
						}
						}
						Server.shutdownServer = true;
					}
				}
				if (sleepTime >= 0)
					Thread.sleep(sleepTime);
				else
					Thread.sleep(600);
				engineTimer.reset();
				itemHandler.process();
				playerHandler.process();	
	            npcHandler.process();
				shopHandler.process();
				CycleEventHandler.getSingleton().process();
				objectManager.process();
				fightPits.process();
				pestControl.process();
				cycleTime = engineTimer.elapsed();
				sleepTime = cycleRate - cycleTime;
				totalCycleTime += cycleTime;
				cycles++;
				debug();
				if (System.currentTimeMillis() - lastMassSave > 3) {
					for(Player p : PlayerHandler.players) {
						if(p == null)
							continue;						
						PlayerSave.saveGame((Client)p);
						lastMassSave = System.currentTimeMillis();
					}
				
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("A fatal exception has been thrown!");
			for(Player p : PlayerHandler.players) {
				if(p == null)
					continue;						
				PlayerSave.saveGame((Client)p);
			}
		}
		acceptor = null;
		connectionHandler = null;
		sac = null;
		System.exit(0);
	}
	
	public static void processAllPackets() {
		for (int j = 0; j < playerHandler.players.length; j++) {
			if (playerHandler.players[j] != null) {
				while(playerHandler.players[j].processQueuedPackets());			
			}	
		}
	}
	
	public static boolean playerExecuted = false;
	private static void debug() {
		if (debugTimer.elapsed() > 360*1000 || playerExecuted) {
			long averageCycleTime = totalCycleTime / cycles;
			double engineLoad = ((double) averageCycleTime / (double) cycleRate);
			System.out.println("Currently online: " + PlayerHandler.playerCount+ ", engine load: "+ debugPercentFormat.format(engineLoad));
			totalCycleTime = 0;
			cycles = 0;
			System.gc();
			System.runFinalization();
			debugTimer.reset();
			playerExecuted = false;
		}
	}
	
	public static long getSleepTimer() {
		return sleepTime;
	}
	
	public static StillGraphicsManager getStillGraphicsManager() {
		return stillGraphicsManager;
	}
	
	public static PlayerManager getPlayerManager() {
		return playerManager;
	}
	
	public static ObjectManager getObjectManager() {
		return objectManager;
	}
	
}
