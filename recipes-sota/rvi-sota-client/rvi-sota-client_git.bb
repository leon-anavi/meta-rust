DESCRIPTION = "SOTA Reference Implementation project - Client"
HOMEPAGE = "https://github.com/advancedtelematic/rvi_sota_client"
LICENSE = "MPL-2.0"

inherit cargo

SRC_URI = "git://github.com/advancedtelematic/rvi_sota_client.git;protocol=https"
SRCREV="57e803803691acab8e443f1631767edaec9da10f"
LIC_FILES_CHKSUM="file://LICENSE;md5=65d26fcc2f35ea6a181ac777e42db1ea"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"

do_install_append() {
 install -m 0755 -p -D ${S}/docker/client.toml ${D}/var/sota/client.toml
}

FILES_${PN} += "/var/sota/"
FILES_${PN} += "/var/sota/client.toml"
