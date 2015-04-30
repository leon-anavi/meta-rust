OVERRIDES .= ":build-${BUILD_ARCH}-${BUILD_OS}"

SRC_URI_append_build-x86_64-linux = "http://static-rust-lang-org.s3.amazonaws.com/cargo-dist/2015-04-02/cargo-nightly-x86_64-unknown-linux-gnu.tar.gz"
SRC_URI_append_build-x86_64-linux[md5sum] = "3d62194d02a9088cd8aae379e9498134"
SRC_URI_append_build-x86_64-linux[sha256sum] = "16b6338ba2942989693984ba4dbd057c2801e8805e6da8fa7b781b00e722d117"
