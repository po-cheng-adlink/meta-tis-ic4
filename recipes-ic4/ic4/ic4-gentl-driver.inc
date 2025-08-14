
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://${PN}_${PV}_Linux_arm64.tar.zst;subdir=${BPN}-${PV};striplevel=1"

inherit bin_package

INSANE_SKIP:${PN} += "already-stripped"
