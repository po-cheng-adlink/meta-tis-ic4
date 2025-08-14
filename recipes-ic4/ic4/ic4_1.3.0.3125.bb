# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://ic4-archive_${PV}_arm64.tar.gz;subdir=${BPN}-${PV};striplevel=1"


inherit bin_package

RDEPENDS:${PN} += "qtbase"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

PACKAGECONFIG ??= "plugins"

INSANE_SKIP:${PN} += "already-stripped file-rdeps"
INSANE_SKIP:${PN}-plugins += "file-rdeps"

PACKAGES =+ "${PN}-plugins"
RDEPENDS:${PN}-plugins += "gstreamer1.0 gstreamer1.0-plugins-base glib-2.0 libgstapp-1.0 mesa freetype"
FILES:${PN}-plugins += "${libdir}/libic4plugin*.so"
