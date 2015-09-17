# 2015-08-03 (rustc-1.3.0, cargo-0.4.0)
SRCREV_cargo = "553b363bcfcf444c5bd4713e30382a6ffa2a52dd"
SRCREV_rust-installer = "c37d3747da75c280237dc2d6b925078e69555499"

CARGO_SNAPSHOT = "2015-04-02/cargo-nightly-x86_64-unknown-linux-gnu.tar.gz"
SRC_URI[md5sum] = "3d62194d02a9088cd8aae379e9498134"
SRC_URI[sha256sum] = "16b6338ba2942989693984ba4dbd057c2801e8805e6da8fa7b781b00e722d117"

require cargo.inc

# curl-rust : 0.2.11  / -sys 0.1.25 {
SRC_URI += " \
	git://github.com/carllerche/curl-rust.git;protocol=https;destsuffix=curl-rust;name=curl-rust \
	file://curl-rust-0.2.11/0001-curl-sys-avoid-explicitly-linking-in-openssl.-If-it-.patch;patchdir=../curl-rust \
	file://curl-rust-0.2.11/0002-remove-per-triple-deps-on-openssl-sys.patch;patchdir=../curl-rust \
"
SRCREV_curl-rust = "64c5c2b4be8c3c19c5b1a74d680b1f4c337e7d4b"
SRCREV_FORMAT .= "_curl-rust"
EXTRA_OECARGO_PATHS += "${WORKDIR}/curl-rust"

# FIXME: we don't actually use these, and shouldn't need to fetch it, but not having it results in:
## target/snapshot/bin/cargo build --target x86_64-linux  --verbose 
## Failed to resolve path '/home/cody/obj/y/tmp/work/x86_64-linux/cargo-native/git+gitAUTOINC+0b84923203_9181ea8f4e_8baa8ccb39-r0/curl-rust/curl-sys/curl/.git': No such file or directory
SRC_URI += "git://github.com/alexcrichton/curl.git;protocol=https;destsuffix=curl-rust/curl-sys/curl;name=curl;branch=configure"
SRCREV_curl = "9a300aa13e5035a795396e429aa861229424c9dc"
# }

# git2-rs : 0.3.1 / -sys 0.3.4 {
SRC_URI += " \
	git://github.com/alexcrichton/git2-rs.git;protocol=https;name=git2-rs;destsuffix=git2-rs \
	file://git2-rs-0.3.1/0001-Add-generic-openssl-sys-dep.patch;patchdir=../git2-rs \
"
SRCREV_git2-rs = "67ddb846b0e47db268d1a47bd5be970974b7683f"
# Used in libgit2-sys's build.rs, needed for pkg-config to be used
export LIBGIT2_SYS_USE_PKG_CONFIG = "1"
SRCREV_FORMAT .= "_git2-rs"
EXTRA_OECARGO_PATHS += "${WORKDIR}/git2-rs"

# FIXME: remove when cargo stops complaining about lacking submodules
SRC_URI += "git://github.com/libgit2/libgit2.git;protocol=https;destsuffix=git2-rs/libgit2-sys/libgit2;name=libgit2"
SRCREV_libgit2 = "47f37400253210f483d84fb9c2ecf44fb5986849"

# }

# 0.2.8 / -sys 0.1.30 {
SRCREV_ssh2-rs = "d5b69eb0db8f1054246c273a3d49c6209dc90366"
SRCREV_FORMAT .= "_ssh2-rs"
EXTRA_OECARGO_PATHS += "${WORKDIR}/ssh2-rs"

SRC_URI += " \
	git://github.com/alexcrichton/ssh2-rs.git;protocol=https;name=ssh2-rs;destsuffix=ssh2-rs \
	file://ssh2-rs-0.2.8/0001-Unconditionally-depend-on-openssl-sys.patch;patchdir=../ssh2-rs \
"
# }


