
package com.cyntain.Fm.network;


import com.cyntain.Fm.network.packet.PacketFm;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;




public class PacketHandler implements IPacketHandler {

    @Override
    public void onPacketData(INetworkManager manager,
            Packet250CustomPayload packet, Player player) {

        PacketFm packetFm = PacketTypeHandler.buildPacket(packet.data);

        packetFm.execute(manager, player);
    }

}
