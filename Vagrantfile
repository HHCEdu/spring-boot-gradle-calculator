# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure(2) do |config|
	config.vm.define :jenkinsslave do |jenkinsslave_config|
      jenkinsslave_config.vm.box = "centos/7"
      jenkinsslave_config.vm.hostname = "jenkins-slave"
      jenkinsslave_config.vm.network :private_network, ip: "192.168.56.31"
      jenkinsslave_config.vm.provider "virtualbox" do |vb|
        vb.memory = "1024"
      end
      #jenkinsslave_config.vm.provision :shell, path: "bootstrap-jenkins-slave.sh"
  end
end