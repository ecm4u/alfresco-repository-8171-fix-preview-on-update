# alfresco-repository-8171-fix-preview-on-update

addresses ecm4u #8171: Reimplement Transformation behavior to avoid ActiveMQ messaging/events subsystems

This patch solves the problem of missing previews when uploading new document versions if messaging is disabled in Alfresco Repostiory.
Since Alfresco 6.2 the creation of a new rendition for a new version is triggered via messaging (!!). The patch implements the previous behaviour via a behaviour to avoid activeMQ just for this use case.

## License

This patch is licensed under the GNU Lesser General Public License (LGPL) v3. See [LICENSE](LICENSE) for the full LGPL license.