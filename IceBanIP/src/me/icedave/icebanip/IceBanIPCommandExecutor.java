package me.icedave.icebanip;

import java.net.InetSocketAddress;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IceBanIPCommandExecutor implements CommandExecutor
{
	
	private IceBanIP plugin;
	
	public IceBanIPCommandExecutor(IceBanIP plugin) 
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender cs, Command cmd, String alias, String[] args) 
	{
		
		if(args.length == 0)
		{
			cs.sendMessage("Please use the correct command :) ");
			return false;
		}
	
		if((alias.equalsIgnoreCase("iceip")) && (!args[0].equalsIgnoreCase("all")))
		{
			
			Player playerToBan = plugin.getServer().getPlayer(args[0].toLowerCase());			
			InetSocketAddress IPAdressPlayer = playerToBan.getAddress();
						
			String undelimited = IPAdressPlayer.toString(); //  /127.0.0.1:34657
			String[] delimitedOne;                          //   127.0.0.1:34657
			//String[] delimitedTwo;                          //   127.0.0.1
			String delimiter = "/";
			//String delimiterTwo = ":";
						
			delimitedOne = undelimited.split(delimiter);        //   127.0.0.1:34657
			//delimitedTwo = delimitedOne[1].split(delimiterTwo); //   127.0.0.1
						
			String IPAddressDelimited = delimitedOne[1];		// 127.0.0.1:34657
			//String IPAddressDelimitedTwo = delimitedTwo[0];     // 127.0.0.1

			if(cs instanceof Player)
			{
				Player player = (Player)cs;
					
				if(player.hasPermission("ice.ipban"))
				{
										
					player.sendMessage("You got the permission to see " + args[0] + "'s IP");
					player.sendMessage(args[0] + "'s IP-Address is : " + IPAddressDelimited);
					
				}
				else
				{
					player.sendMessage(ChatColor.RED + "You got no permissions to see " + args[0] + "'s IP ");
				}
			}
			else
			{
				cs.sendMessage(args[0] + "'s IP-Address is : " + IPAddressDelimited);
			}

		}
		else
		{
			if((alias.equalsIgnoreCase("iceban")) && (!args[0].equalsIgnoreCase("all")))
			{
				
				Player playerToBan = plugin.getServer().getPlayer(args[0].toLowerCase());			
				InetSocketAddress IPAdressPlayer = playerToBan.getAddress();
							
				String undelimited = IPAdressPlayer.toString(); //  /127.0.0.1:34657
				String[] delimitedOne;                          //   127.0.0.1:34657
				String[] delimitedTwo;                          //   127.0.0.1
				String delimiter = "/";
				String delimiterTwo = ":";
							
				delimitedOne = undelimited.split(delimiter);        //   127.0.0.1:34657
				delimitedTwo = delimitedOne[1].split(delimiterTwo); //   127.0.0.1
							
				String IPAddressDelimited = delimitedOne[1];		// 127.0.0.1:34657
				String IPAddressDelimitedTwo = delimitedTwo[0];     // 127.0.0.1
				
				if(cs instanceof Player)
				{
					Player player = (Player)cs;
						
					if(player.hasPermission("ice.ipban"))
					{
						player.sendMessage(args[0] + "'s IP-Address : " + IPAddressDelimited + " is now banned");
						plugin.getServer().banIP(IPAddressDelimitedTwo);
					
					}
					else
					{
						player.sendMessage(ChatColor.RED + "You got no permissions to ban " + args[0] + "'s IP ");
					}
				}
				else
				{
					cs.sendMessage(args[0] + "'s IP-Address : " + IPAddressDelimited + " is now banned");
					plugin.getServer().banIP(IPAddressDelimitedTwo);
				}
			}
			else
			{
				if((alias.equalsIgnoreCase("icebk")) && (!args[0].equalsIgnoreCase("all")))
				{
					
					Player playerToBan = plugin.getServer().getPlayer(args[0].toLowerCase());			
					InetSocketAddress IPAdressPlayer = playerToBan.getAddress();
								
					String undelimited = IPAdressPlayer.toString(); //  /127.0.0.1:34657
					String[] delimitedOne;                          //   127.0.0.1:34657
					String[] delimitedTwo;                          //   127.0.0.1
					String delimiter = "/";
					String delimiterTwo = ":";
								
					delimitedOne = undelimited.split(delimiter);        //   127.0.0.1:34657
					delimitedTwo = delimitedOne[1].split(delimiterTwo); //   127.0.0.1
								
					String IPAddressDelimited = delimitedOne[1];		// 127.0.0.1:34657
					String IPAddressDelimitedTwo = delimitedTwo[0];     // 127.0.0.1
					
					if(cs instanceof Player)
					{
						Player player = (Player)cs;
							
						if(player.hasPermission("ice.ipban"))
						{
												
							player.sendMessage(args[0] + "'s IP-Address : " + IPAddressDelimited + " is now banned and kicked from the server");
							plugin.getServer().banIP(IPAddressDelimitedTwo);
							playerToBan.kickPlayer("You are a bad person mate... you been kicked from this server");
							
						
						}
						else
						{
							player.sendMessage(ChatColor.RED + "You got no permissions to ban " + args[0] + "'s IP and kick him from the server");
						}
					}
					else
					{
						cs.sendMessage(args[0] + "'s IP-Address is : " + IPAddressDelimited);
						cs.sendMessage(args[0] + "'s IP-Address : " + IPAddressDelimited + " is now banned and kicked from the server");
						plugin.getServer().banIP(IPAddressDelimitedTwo);
						playerToBan.kickPlayer("You are a bad person mate... you been kicked from this server");
					}
				}
				else
				{
					if((alias.equalsIgnoreCase("icelist")) && (args[0].equalsIgnoreCase("all")))
					{						
						if(cs instanceof Player){
							Player player = (Player)cs;
								
							if(player.hasPermission("ice.ipban"))
							{
								// This part comes anyway after the list was printed
								player.sendMessage("List of every onlineplayer with IP-Adress");
								
								for (Player onlinePlayer : plugin.getServer().getOnlinePlayers())
								{
										String onlinePlayerName = onlinePlayer.getName();
										InetSocketAddress onlinePlayerIP = onlinePlayer.getAddress();
										
										String undelimited = onlinePlayerIP.toString(); //  /127.0.0.1:34657
										String[] delimitedOne;                          //   127.0.0.1:34657
										String[] delimitedTwo;                          //   127.0.0.1
										String delimiter = "/";
										String delimiterTwo = ":";
													
										delimitedOne = undelimited.split(delimiter);        //   127.0.0.1:34657
										delimitedTwo = delimitedOne[1].split(delimiterTwo); //   127.0.0.1
													
										//String IPAddressDelimited = delimitedOne[1];		// 127.0.0.1:34657
										String IPAddressDelimitedTwo = delimitedTwo[0];     // 127.0.0.1
										
										player.sendMessage(onlinePlayerName + " : " + IPAddressDelimitedTwo);
								}
							}
							else
							{
								player.sendMessage(ChatColor.RED + "You got no permissions to see the IP list from all onlineplayers");
							}
						}
						else
						{
							// This part comes anyway after the list was printed
							cs.sendMessage("List of every onlineplayer with IP-Adress");
							
							for (Player onlinePlayer : plugin.getServer().getOnlinePlayers())
							{
									String onlinePlayerName = onlinePlayer.getName();
									InetSocketAddress onlinePlayerIP = onlinePlayer.getAddress();
									
									String undelimited = onlinePlayerIP.toString(); //  /127.0.0.1:34657
									String[] delimitedOne;                          //   127.0.0.1:34657
									String[] delimitedTwo;                          //   127.0.0.1
									String delimiter = "/";
									String delimiterTwo = ":";
												
									delimitedOne = undelimited.split(delimiter);        //   127.0.0.1:34657
									delimitedTwo = delimitedOne[1].split(delimiterTwo); //   127.0.0.1
												
									//String IPAddressDelimited = delimitedOne[1];		// 127.0.0.1:34657
									String IPAddressDelimitedTwo = delimitedTwo[0];     // 127.0.0.1
									
									cs.sendMessage(onlinePlayerName + " : " + IPAddressDelimitedTwo);
									
							}
						}
					}
					//Here should start the new one for pages with else{}
					else
					{
						if((alias.equalsIgnoreCase("icelist")) && (args[0].equalsIgnoreCase("1")))
						{						
							if(cs instanceof Player){
								Player player = (Player)cs;
									
								if(player.hasPermission("ice.ipban"))
								{
									// This part comes anyway after the list was printed
									player.sendMessage("List of every onlineplayer with IP-Adress page 1 of ??");
									player.sendMessage("This part is not finished yet ... coming soon");
									
									for (Player onlinePlayer : plugin.getServer().getOnlinePlayers())
									{
											String onlinePlayerName = onlinePlayer.getName();
											InetSocketAddress onlinePlayerIP = onlinePlayer.getAddress();
											
											String undelimited = onlinePlayerIP.toString(); //  /127.0.0.1:34657
											String[] delimitedOne;                          //   127.0.0.1:34657
											String[] delimitedTwo;                          //   127.0.0.1
											String delimiter = "/";
											String delimiterTwo = ":";
														
											delimitedOne = undelimited.split(delimiter);        //   127.0.0.1:34657
											delimitedTwo = delimitedOne[1].split(delimiterTwo); //   127.0.0.1
														
											//String IPAddressDelimited = delimitedOne[1];		// 127.0.0.1:34657
											String IPAddressDelimitedTwo = delimitedTwo[0];     // 127.0.0.1
											
											player.sendMessage(onlinePlayerName + " : " + IPAddressDelimitedTwo);
									}
								}
								else
								{
									player.sendMessage(ChatColor.RED + "You got no permissions to see the IP list from all onlineplayers");
								}
							}
							else
							{
								// This part comes anyway after the list was printed
								cs.sendMessage("List of every onlineplayer with IP-Adress");
								
								for (Player onlinePlayer : plugin.getServer().getOnlinePlayers())
								{
										String onlinePlayerName = onlinePlayer.getName();
										InetSocketAddress onlinePlayerIP = onlinePlayer.getAddress();
										
										String undelimited = onlinePlayerIP.toString(); //  /127.0.0.1:34657
										String[] delimitedOne;                          //   127.0.0.1:34657
										String[] delimitedTwo;                          //   127.0.0.1
										String delimiter = "/";
										String delimiterTwo = ":";
													
										delimitedOne = undelimited.split(delimiter);        //   127.0.0.1:34657
										delimitedTwo = delimitedOne[1].split(delimiterTwo); //   127.0.0.1
													
										//String IPAddressDelimited = delimitedOne[1];		// 127.0.0.1:34657
										String IPAddressDelimitedTwo = delimitedTwo[0];     // 127.0.0.1
										
										cs.sendMessage(onlinePlayerName + " : " + IPAddressDelimitedTwo);
										
								}
							}
						}
						return true;
					}             
					return true;	
				}
				return true;
			}
			return true;
		}
		return true;
	}

}




















