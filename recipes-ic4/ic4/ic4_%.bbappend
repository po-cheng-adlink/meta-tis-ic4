SRC_URI:append = " file://ic4camera.sh"

do_install:append() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/ic4camera.sh ${D}${sysconfdir}/profile.d/
}

FILES:${PN} += "${sysconfdir}/profile.d/ic4camera.sh"

