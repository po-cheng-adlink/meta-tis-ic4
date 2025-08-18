include ic4-gentl-driver.inc

RDEPENDS:${PN} = "util-linux-libuuid libusb1"

do_install:append() {
  if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
    #enable the service
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    ln -sf ${systemd_unitdir}/system/ic4-gentl-u3v.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/ic4-gentl-u3v.service
  fi
}

