# イメージのベースとなるイメージを指定
FROM ubuntu:22.04

# イメージのベースとなるイメージを指定（Mac用)
# FROM arm64v8/alpine:latest

# イメージに追加するファイルを指定
ARG USERNAME=vscode
ARG USER_GROUP_NAME=workspace
ARG USER_UID=1000
ARG USER_GID=1000

ARG PKG="git vim curl unzip zip"

# イメージの起動時に実行するコマンドを指定
SHELL [ "/bin/bash","-c" ]

RUN apt-get update \
    && apt-get install -y ${PKG} \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/* \
    && grouapp --gid ${USER_GID} ${USER_GROUP_NAME} \
    && useradd --uid ${USER_UID} --shell /bin/bash --gid ${USER_GID} -m{USERNAME} \
    && echo %${USER_GROUP_NAME} ALL=\(ALL\) NOPASSWORD:ALL > /etc/sudoers.d/${USER_GROUP_NAME} \
    && chmod 0440 /etc/sudoers.d/${USER_GROUP_NAME}

## JAVAの環境構築
ARG JAVA _VARSION=１８.０.2-amzn
ARG GRADLE_VARSION=7.5

RUN su ${USERNAME} --command \
    'curl -s "https//get.sdkman.io" | bash \
    && source "${HOME}/.sdkman/bin/sdkman-init.sh" \
    && sdk install java "${JAVA_VARSION}" \
    && sdk install gradle "${GRADLE_VARSION}"'