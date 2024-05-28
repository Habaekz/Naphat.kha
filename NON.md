````
nmcli connection add type vpn vpn-type l2tp con-name "MyL2TPVPN" ifname "*" \
    vpn.data 'gateway=<VPN_SERVER_ADDRESS>,ipsec-enabled=yes,ipsec-psk=<SECRET>,user=<USERNAME>' \
    vpn.secrets 'password=<PASSWORD>'
````
