import time


class Alice:
    def __init__(self):
        self.packets_to_send = []

    def create_packet(self, packet):
        self.packets_to_send.append(packet)

    def has_packets_to_send(self):
        return len(self.packets_to_send) > 0

    def send_packet(self):
        if self.has_packets_to_send():
            packet = self.packets_to_send.pop(0)
            return packet
        else:
            return None


class Bob:
    def __init__(self):
        self.received_packets = []

    def receive_packet(self, packet):
        self.received_packets.append(packet)

    def has_packets_to_read(self):
        return len(self.received_packets) > 0

    def read_packet(self):
        if self.has_packets_to_read():
            packet = self.received_packets.pop(0)
            return packet
        else:
            return None


# Simulation
alice = Alice()
bob = Bob()

# Alice creates packets and sends them to Bob
alice.create_packet("Packet 1")
alice.create_packet("Packet 2")
alice.create_packet("Packet 3")

while alice.has_packets_to_send():
    packet = alice.send_packet()
    print("Sending packet:", packet)
    time.sleep(1)  # Simulating time for packet delivery
    bob.receive_packet(packet)

# Bob reads and deletes packets received from Alice
while bob.has_packets_to_read():
    packet = bob.read_packet()
    print("Bob received and read packet:", packet)
