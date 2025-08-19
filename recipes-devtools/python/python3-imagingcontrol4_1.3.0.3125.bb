SUMMARY = "The Imaging Source SDK for GenTL based camera interactions."
HOMEPAGE = "https://www.theimagingsource.com/en-us/"
LICENSE = "CLOSED"

inherit python3-dir setuptools3

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"

#https://files.pythonhosted.org/packages/07/69/5a43995037b378257ce397fcdd068a14b3c380c42b305b4ee0c306aece6d/imagingcontrol4-1.3.0.3125-py38-none-manylinux_2_27_aarch64.whl
SRC_URI = "https://files.pythonhosted.org/packages/07/69/5a43995037b378257ce397fcdd068a14b3c380c42b305b4ee0c306aece6d/${WHL_PN}-${PV}-py38-none-manylinux_2_27_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-py38-none-manylinux_2_27_${TARGET_ARCH}.whl;subdir=dist"
SRC_URI[sha256sum] = "164de0eb38ddb05033b562e63a35fc6adbb380c4d28ce3aec37304de82fd3880"

S = "${WORKDIR}"

do_compile[noexec] = "1"
INSANE_SKIP:${PN} += "file-rdeps"

RDEPENDS:${PN} = "\
    python3-numpy \
    python3-pyside6 \
"

#do_pyproject_conf() {
#    echo "[project]" >> ${WORKDIR}/dist/pyproject.toml
#    echo "name = \"imagingcontrol4\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "version = \"1.3.0.3125\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "summary = \"IC Imaging Control 4 Core Library\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "requires-python = \">= 3.8\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "dependencies = [\"numpy\", \"pyside6\"]" >> ${WORKDIR}/dist/pyproject.toml
#    echo "" >> ${WORKDIR}/dist/pyproject.toml
#    echo "[tool.setuptools.packages.find]" >> ${WORKDIR}/dist/pyproject.toml
#    echo "where = [\"./\"]" >> ${WORKDIR}/dist/pyproject.toml
#}
#addtask pyproject_conf before do_configure after do_patch

